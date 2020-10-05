package com.ssf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssf.util.json.*;

@Controller
public class CheckPassword {

	
	@RequestMapping("checkpassword.do")
	public String Checkpassword(String password , String passwordagain) {
		
		//密码一致,发送出题请求
		if (password.equals(passwordagain)) {
			return "redirect:makequestion.do";
		}
		
		//刷新本页面
		return "checkpassword";
	}
	
}
