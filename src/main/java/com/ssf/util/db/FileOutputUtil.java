package com.ssf.util.db;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class FileOutputUtil {
	
	public static void SavePaper(int nums, List<String> questionList, String type)
			throws IOException, FileNotFoundException 
	{
		
		

		// 获取当前时间
		//SimpleDateFormat format = new SimpleDateFormat("yyyy年-MM月-dd日-HH时-mm分-ss秒");
		//String date = format.format(new Date());

		// 创建该类型题目的文件夹
		File file = new File(".//QuestionDB//"+type);
		if (!file.exists())
		{
			file.mkdirs();
		}
		PrintWriter out = new PrintWriter(
				new OutputStreamWriter(new FileOutputStream(".//QuestionDB//"+type+"//"+type+"_Questions.txt"), "UTF-8"));
		for (int i = 0; i < nums; i++) 
		{
			out.write(String.valueOf(i+1)+"."+"请求出表达式"+questionList.get(i)+"的值"+"\n");
			out.flush();
			out.write("\n");
			out.flush();
		}

		out.close();
	}
}
