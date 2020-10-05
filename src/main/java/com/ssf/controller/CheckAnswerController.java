package com.ssf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ssf.util.json.Scorejson;

@Controller
public class CheckAnswerController {
	
	public String[] m_answers; //答案数组
	
	/**
	 * 接收用户答案json
	 * @param answerjson
	 * @return 封装分数的json对象
	 */
	@ResponseBody
	public Scorejson CheckTheAnswers(String answerjson) {
		
		
		//解析为json数组
		JSONArray jsonArray = JSONArray.parseArray(answerjson);
		
		double score = (double)(100/jsonArray.size());//每一道题分数
		double totalscore = 0.0;
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			if(jsonObject!=null) {
				String answer = jsonObject.getString(String.valueOf(i));
				if (answer.equals(m_answers[i])) {
					totalscore+=score;
				}
			}
		}
		
		Scorejson jScorejson = new Scorejson();
		jScorejson.setScore(score);
		return jScorejson;
	}
}
