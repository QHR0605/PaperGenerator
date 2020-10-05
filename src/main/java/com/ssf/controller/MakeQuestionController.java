package com.ssf.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssf.service.QuesServiceImpl;
import com.ssf.util.constant.Constant;
import com.ssf.util.db.FileInputUtil;
import com.ssf.util.json.*;
import com.ssf.util.makeExpressions.MakeExpressions;
import com.sun.org.apache.bcel.internal.generic.NEW;

@Controller
public class MakeQuestionController {
	
	@Autowired
	QuesServiceImpl quesService;
	
	Map<String,String> getQuesFromDB = new HashMap<String, String>();//题库里的题,用于查重
	Map<String, String> result = new HashMap<String, String>();//当前生成的一套题和对应答案
	List<String> expressions = new LinkedList<String>();
	QuesAndAnswersJson json;
	/**
	 * 
	 * 
	 * @return 封装题目和答案的Json对象
	 * @throws Exception 
	 */
	@RequestMapping("makequestion.do")
	@ResponseBody
	public QuesAndAnswersJson MakeQues(int level , int numbers) throws Exception {
		
		json = quesService.MakeQues(level, numbers);
		return json;
		
		
	}
	
	public static void main(String[] args) throws Exception {
		MakeQuestionController controller = new MakeQuestionController();
		QuesAndAnswersJson json =  controller.MakeQues(0, 10);
		Map<String, String> map = json.getM_quesAndanswers();
		for (Entry<String, String> entry:map.entrySet()) {
			System.out.println(entry.getKey());
		}
	}
}
