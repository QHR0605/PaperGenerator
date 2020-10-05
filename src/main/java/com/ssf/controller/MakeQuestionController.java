package com.ssf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssf.service.QuesServiceImpl;
import com.ssf.util.json.*;

/**
 * 这里免去了随机生成题目的环节
 * 直接进行文件读取题目和对应答案
 * @author 全鸿润
 *
 */
@Controller
public class MakeQuestionController {
	
	@Autowired
	QuesServiceImpl quesService;
	
	
	/**
	 * 调用文件输入流取出所有试题
	 * 再去重
	 * @return
	 */
	@RequestMapping("makequestion.do")
	@ResponseBody
	public QuesAndAnswersJson MakeQues(int level , int number) {
		
		if (level==0) {
			
		}else if (level==1) {
			
		}else if (level==2) {
			
		}
		return null;
		
		
	}
}
