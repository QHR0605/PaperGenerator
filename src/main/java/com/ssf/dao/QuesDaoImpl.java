package com.ssf.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

import org.apache.jasper.tagplugins.jstl.core.If;

import com.alibaba.fastjson.asm.Label;
import com.ssf.util.constant.Constant;
import com.ssf.util.db.FileInputUtil;
import com.ssf.util.db.FileOutputUtil;
import com.ssf.util.json.QuesAndAnswersJson;
import com.ssf.util.makeExpressions.MakeExpressions;

public class QuesDaoImpl implements QuesDao {
	
	Map<Integer,String> getQuesFromDB = new HashMap<Integer, String>();//题库里的题,用于查重
	Map<Integer, String> result = new HashMap<Integer, String>();//当前生成的一套题和对应答案
	List<String> expressions = new LinkedList<String>();

	/**
	 * 接收类型和数目,返回map
	 */
	@Override
	public Map<Integer, String> GetPaper(String level, int numbers) throws IOException {
		
		
		getQuesFromDB = FileInputUtil.GetPrimaryQuestionFromDB(level);
		
		if (level.equals("小学")) 
		{
			if (getQuesFromDB.size()==0)
			{
				for (int i = 0; i < numbers; i++) 
				{
					String expression = MakeExpressions.MakeExpression();
					result.put(i,expression+"=");
				}
			}
			else 
			{
				int count = 0;
				Label1:	while (true) 
					{   
						for (Entry<Integer, String> entry : getQuesFromDB.entrySet()) {
							
							if (count>=numbers) {
								break Label1;
							}
							String expression = MakeExpressions.MakeExpression();
							if (!expression.equals(entry.getKey())) {
								result.put( count++,expression+"=");
							}
						}
						
					}
			}
		}
		
		if (level.equals("初中")) 
		{
			if (getQuesFromDB.size()==0)
			{
				for (int i = 0; i < numbers; i++) 
				{
					String expression = MakeExpressions.MakeMiddleExpression();
					result.put(i,expression+"=");
				}
			}else 
			{
				int count = 0;
				Label1:	while (true) 
					{   
						for (Entry<Integer, String> entry : getQuesFromDB.entrySet()) {
							
							if (count>=numbers) {
								break Label1;
							}
							String expression = MakeExpressions.MakeMiddleExpression();
							if (!expression.equals(entry.getKey())) {
								result.put( count++,expression+"=");
							}
						}
						
					}
			}
		}
		
		
		if (level.equals("高中")) 
		{
			if (getQuesFromDB.size()==0)
			{
				for (int i = 0; i < numbers; i++) 
				{
					String expression = MakeExpressions.MakeHightExprssion();
					result.put(i,expression+"=");
				}
			}else 
			{
				int count = 0;
				Label1:	while (true) 
					{   
						for (Entry<Integer, String> entry : getQuesFromDB.entrySet()) {
							
							if (count>=numbers) {
								break Label1;
							}
							String expression = MakeExpressions.MakeHightExprssion();
							if (!expression.equals(entry.getKey())) {
								result.put( count++,expression+"=");
							}
						}
						
					}
			}
		}
		
		
		FileOutputUtil.SavePaper(numbers, result, level); //存入题库
		
		return result;
	}

	
}
