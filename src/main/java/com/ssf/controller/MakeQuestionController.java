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

/**
 * ������ȥ�����������Ŀ�Ļ���
 * ֱ�ӽ����ļ���ȡ��Ŀ�Ͷ�Ӧ��
 * @author ȫ����
 *
 */
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
	 * @throws IOException 
	 */
	@RequestMapping("makequestion.do")
	@ResponseBody
	public QuesAndAnswersJson MakeQues(int level , int numbers) throws IOException {
		
		//小学
		if (level==0) 
		{
			getQuesFromDB = FileInputUtil.GetPrimaryQuestionFromDB("小学");
			if (getQuesFromDB.size()==0)
			{
				for (int i = 0; i < numbers; i++) 
				{
					String expression = MakeExpressions.MakeExpression();
					result.put(Constant.c_declaretion+expression, String.valueOf(new Random().nextInt(6)));
				}
			}else 
			{
				for (Entry<String, String> entry : getQuesFromDB.entrySet()) 
				{
					while (true) 
					{
						String expression = MakeExpressions.MakeExpression();
						if (!expression.equals(entry.getKey())) {
							result.put(expression, String.valueOf(new Random().nextInt(6)));
						}
					}
				}
			}
		}
		//初中
		else if (level==1) 
		{
			getQuesFromDB = FileInputUtil.GetPrimaryQuestionFromDB("初中");
			if (getQuesFromDB.size()==0) 
			{
				for (int i = 0; i < numbers; i++)
				{
					String expression = MakeExpressions.MakeExpression();
					result.put(Constant.c_declaretion+expression, String.valueOf(new Random().nextInt(6)));
				}
			}else 
			{
				for (Entry<String, String> entry : getQuesFromDB.entrySet())
				{
					while (true) 
					{
						String expression = MakeExpressions.MakeExpression();
						if (!expression.equals(entry.getKey())) 
						{
							result.put(expression, String.valueOf(new Random().nextInt(6)));
						}
					}
				}
			}
		}
		//高中
		else if (level==2) 
		{
			getQuesFromDB = FileInputUtil.GetPrimaryQuestionFromDB("高中");
			if (getQuesFromDB.size()==0) 
			{
				for (int i = 0; i < numbers; i++) 
				{
					String expression = MakeExpressions.MakeExpression();
					result.put(Constant.c_declaretion+expression, String.valueOf(new Random().nextInt(6)));
			
				}
			}
			else 
			{
				for (Entry<String, String> entry : getQuesFromDB.entrySet()) 
				{
					while (true)
					{
						String expression = MakeExpressions.MakeExpression();
						if (!expression.equals(entry.getKey()))
						{
							result.put(expression, String.valueOf(new Random().nextInt(6)));
						}
					}
				}
			}
		}
		
		json.setM_quesAndanswers(result);
		json.setState(1); 
		
		return json;
		
		
	}
}
