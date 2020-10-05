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
 * 注册界面
 * 1.进入注册页面
 * 2.接收手机号和验证码
 * 3.处理请求的方法返回json对象{注册状态码,提示信息};
 * @author 全鸿润
 *
 */
@Controller
public class RegesterController {
	
	@Autowired
	SmsServiceImpl sms;
	
	/**
	 * 输入手机号和验证码页面
	 * 对应的jsp文件名为reg.jsp
	 * @return
	 */
	@RequestMapping("reg.do")
	public String reg() {
		return "reg";
	}
	/**
	 * 发送手机验证码请求处理方法
	 * 验证完后返回json对象{
	 *   
	 *   state:
	 *   message:
	 * }
	 * @param request
	 * @param number
	 * @return
	 */
	@RequestMapping("sendsms.do")
	@ResponseBody  //该注解表示直接返回正文,不进行页面的跳转
	public  JsonResult	sendsms(HttpServletRequest request,String number) {
		
		/**
		 * 1.生成验证码
		 * 2.调用短信发送的API
		 * 3.将验证码和创建时间存入json,同时存入session
		 * 4.设置json的提示信息
		 * 5.重定向到密码确定界面/在本页面进行错误提示
		 */
		JsonResult result = new JsonResult(); //自定义的json格式
		JSONObject json = null;
		String verifycode = String.valueOf(new Random().nextInt(899999)+100000);
		try {
			CommonResponse response = sms.sendMessage(number);
			json = JSON.parseObject(response.getData());
			if (!json.getInteger("Code").equals("OK")) {
				result.setMessage("验证码发送失败!请重试");
				result.setState(2);
			}
			
			//result.setMessage("验证码成功!");
			result.setState(1);
			result.setMessage("验证码发送成功!");
			
			HttpSession session = request.getSession(); //存入session以便和后续输入的验证码比较
			json = new JSONObject();
			json.put("verifycode", verifycode); //验证码
			json.put("createTime", System.currentTimeMillis());//创建时间
			session.setAttribute("verifcode", json);
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	/**
	 * 接收手机号码和验证码
	 * 验证完后返回json对象{
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
	public String handle_reg(String number,String verrifcode,HttpSession session) {
		
		JSONObject jsonObject = (JSONObject) session.getAttribute(verrifcode);
		JsonResult result = new JsonResult();
		if (!verrifcode.equals(jsonObject.getString(verrifcode))) {
			result.setState(2);
			result.setMessage("验证码输入错误,请重试");
		}
		
		result.setState(1);
		result.setMessage("验证码输入正确");
		return "redirect:chackpassword.do"; //重定向转到输入密码页面
	}
	
	public static void main(String[] args) {
		
	}
}
