package com.ssf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssf.util.JsonResult;

@Controller
public class CheckPassword {

	
	@RequestMapping("chackpassword.do")
	public String Checkpassword(String password , String passwordagain) {
		
		JsonResult result = new JsonResult();
		
		if(!password.equals(passwordagain)) {
			
			result.setState(2);
			result.setMessage("两次输入的密码不正确,请重新输入");
		}
		
		result.setState(1);
		result.setMessage("注册成功");
		
		return "下一个页面视图名称";
	}
	
}
