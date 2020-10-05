package com.ssf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssf.util.json.*;

@Controller
public class CheckPassword {

	
	@RequestMapping("checkpassword.do")
	public String Checkpassword(String password , String passwordagain) {
		
		//如果两次密码一致则跳转到出题界面
		if (password.equals(passwordagain)) {
			return "redirect:makequestion.do";
		}
		
		//不一致则刷新当前界面
		return "makequestion";
	}
	
}
