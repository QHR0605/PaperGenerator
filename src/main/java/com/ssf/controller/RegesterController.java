package com.ssf.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssf.service.SmsServiceImpl;
import com.ssf.util.json.*;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.alibaba.fastjson.*;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.profile.DefaultProfile;

/**
 * 
 * 1.获取手机号码
 * 2.生成验证码并保存,以便后面查证
 * 3.返回的json对象{
 * 	state:
 *  message:
 * }
 * @author 全鸿润
 *
 */
@Controller
public class RegesterController {
	
	@Autowired
	SmsServiceImpl sms;
	
	@RequestMapping("reg.do")
	public String reg() {
		
		return "reg";
	}
	
	/**
	 * 发送验证码
	 * 返回json对象{
	 *   
	 *   state:
	 *   message:
	 * }
	 * @param request
	 * @param number
	 * @return
	 */
	@RequestMapping("sendsms.do")
	@ResponseBody    
	public  JsonResult	sendsms(HttpServletRequest request,String numberjson) {
		
		/**
		 * 1.生成六位验证码
		 * 2.调用阿里云API
		 */
		//解析json对象获取手机号
		JSONObject jsonObject = JSONObject.parseObject(numberjson);
		String number = jsonObject.getString("phone");
		
		JsonResult result = new JsonResult(); 
		JSONObject json = null;
		//生成六位随机数
		String verifycode = String.valueOf(new Random().nextInt(899999)+100000);
		try {
			CommonResponse response = sms.sendMessage(number,verifycode);
			json = JSON.parseObject(response.getData());
			//提取关键值Code的值
			if (!json.getInteger("Code").equals("OK")) {
				result.setMessage("验证码输入错误");
				result.setState(2);
			}
			
			result.setState(1);
			result.setMessage("验证码输入正确");
			
			HttpSession session = request.getSession(); //session存储生成的验证码和创建时间
			json = new JSONObject();
			json.put("verification", verifycode); 
			json.put("createTime", System.currentTimeMillis());
			session.setAttribute("verification", json);
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	/**
	 * 获取输入的验证码和手机号码
	 * 返回的json格式{
	 *   
	 *   state:
	 *   message:
	 * }
	 * @param number
	 * @param verrifcode
	 * @return
	 */
	@RequestMapping("handle_reg.do")
	@ResponseBody
	public JsonResult handle_reg(String verifcodejson,HttpSession session) {
		
		JSONObject vericodeJsonObject = JSONObject.parseObject(verifcodejson);
		String verrifcode = vericodeJsonObject.getString("verification"); //提取出输入的验证码
		JSONObject jsonObject = (JSONObject) session.getAttribute(verrifcode); //之前存入的验证码
		JsonResult result = new JsonResult();
		if (!verrifcode.equals(jsonObject.getString(verrifcode))) {
			result.setState(2);
			result.setMessage("验证码输入错误!");
		}
		
		result.setState(1);
		result.setMessage("验证码输入正确");
		return result;
	}
}
