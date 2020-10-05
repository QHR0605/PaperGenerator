package com.ssf.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

import com.ssf.util.constant.Constant;
import com.ssf.util.db.FileInputUtil;
import com.ssf.util.json.QuesAndAnswersJson;
import com.ssf.util.makeExpressions.MakeExpressions;

public class QuesDaoImpl implements QuesDao {
	
	Map<String,String> getQuesFromDB = new HashMap<String, String>();//题库里的题,用于查重
	Map<String, String> result = new HashMap<String, String>();//当前生成的一套题和对应答案
	List<String> expressions = new LinkedList<String>();

	/**
	 * 接收类型和数目,返回map
	 */
	@Override
	public Map<String, String> GetPaper(String level, int numbers) throws IOException {
		
		getQuesFromDB = FileInputUtil.GetPrimaryQuestionFromDB(level);
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
		
		return result;
	}

	
}
