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
 * ע�����
 * 1.����ע��ҳ��
 * 2.�����ֻ��ź���֤��
 * 3.��������ķ�������json����{ע��״̬��,��ʾ��Ϣ};
 * @author ȫ����
 *
 */
@Controller
public class RegesterController {
	
	@Autowired
	SmsServiceImpl sms;
	
	/**
	 * �����ֻ��ź���֤��ҳ��
	 * ��Ӧ��jsp�ļ���Ϊreg.jsp
	 * @return
	 */
	@RequestMapping("reg.do")
	public String reg() {
		return "reg";
	}
	/**
	 * �����ֻ���֤����������
	 * ��֤��󷵻�json����{
	 *   
	 *   state:
	 *   message:
	 * }
	 * @param request
	 * @param number
	 * @return
	 */
	@RequestMapping("sendsms.do")
	@ResponseBody  //��ע���ʾֱ�ӷ�������,������ҳ�����ת
	public  JsonResult	sendsms(HttpServletRequest request,String number) {
		
		/**
		 * 1.������֤��
		 * 2.���ö��ŷ��͵�API
		 * 3.����֤��ʹ���ʱ�����json,ͬʱ����session
		 * 4.����json����ʾ��Ϣ
		 * 5.�ض�������ȷ������/�ڱ�ҳ����д�����ʾ
		 */
		JsonResult result = new JsonResult(); //�Զ����json��ʽ
		JSONObject json = null;
		String verifycode = String.valueOf(new Random().nextInt(899999)+100000);
		try {
			CommonResponse response = sms.sendMessage(number);
			json = JSON.parseObject(response.getData());
			if (!json.getInteger("Code").equals("OK")) {
				result.setMessage("��֤�뷢��ʧ��!������");
				result.setState(2);
			}
			
			//result.setMessage("��֤��ɹ�!");
			result.setState(1);
			result.setMessage("��֤�뷢�ͳɹ�!");
			
			HttpSession session = request.getSession(); //����session�Ա�ͺ����������֤��Ƚ�
			json = new JSONObject();
			json.put("verifycode", verifycode); //��֤��
			json.put("createTime", System.currentTimeMillis());//����ʱ��
			session.setAttribute("verifcode", json);
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	/**
	 * �����ֻ��������֤��
	 * ��֤��󷵻�json����{
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
			result.setMessage("��֤���������,������");
		}
		
		result.setState(1);
		result.setMessage("��֤��������ȷ");
		return "redirect:chackpassword.do"; //�ض���ת����������ҳ��
	}
	
	public static void main(String[] args) {
		
	}
}
