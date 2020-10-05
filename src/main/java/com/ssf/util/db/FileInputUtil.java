package com.ssf.util.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.sun.org.apache.bcel.internal.generic.NEW;


/**
 * 读取题目,并返回map<题目，答案>
 * @author 全鸿润
 *
 */
public class FileInputUtil {

	
	
		public static Map<String,String> GetPrimaryQuestionFromDB(String type) throws IOException 
		{
			
			
			BufferedReader reader = null;
			Map<String, String> result = new HashMap<String, String>();
			File file = new File(".//QuestionDB//"+type);
			if (!file.exists())
			{
				file.mkdirs();
			}
			
			
			try 
			{
				reader = new BufferedReader(new InputStreamReader(new FileInputStream(".//QuestionDB//"+type+"//"+type+"_Questions.txt"),"UTF-8"));
				String line = null;
				while ((line=reader.readLine())!=null) 
				{
					result.put(line, String.valueOf(new Random().nextInt(6)));
				}
				reader.close();
			} catch (Exception e) 
			{
				return new HashMap();
			}
			
			return result;
			
		}
}
