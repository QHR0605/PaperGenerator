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
		
		

		// ��ȡ��ǰʱ��
		//SimpleDateFormat format = new SimpleDateFormat("yyyy��-MM��-dd��-HHʱ-mm��-ss��");
		//String date = format.format(new Date());

		// ������������Ŀ���ļ���
		File file = new File(".//QuestionDB//"+type);
		if (!file.exists())
		{
			file.mkdirs();
		}
		PrintWriter out = new PrintWriter(
				new OutputStreamWriter(new FileOutputStream(".//QuestionDB//"+type+"//"+type+"_Questions.txt"), "UTF-8"));
		for (int i = 0; i < nums; i++) 
		{
			out.write(String.valueOf(i+1)+"."+"��������ʽ"+questionList.get(i)+"��ֵ"+"\n");
			out.flush();
			out.write("\n");
			out.flush();
		}

		out.close();
	}
}
