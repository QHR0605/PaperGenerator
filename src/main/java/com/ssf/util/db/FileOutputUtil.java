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
import java.util.Map;
import java.util.Map.Entry;


/**
 * 每个类型存一份该类型的题目文件
 * @author 全鸿润
 *
 */
public class FileOutputUtil {
	
	public static void SavePaper(int nums, Map<Integer, String> questionList, String type)
			throws IOException, FileNotFoundException 
	{
		
		File file = new File(".//QuestionDB//"+type);
		if (!file.exists())
		{
			file.mkdirs();
		}
		PrintWriter out = new PrintWriter(
				new OutputStreamWriter(new FileOutputStream(".//QuestionDB//"+type+"//"+type+"_Questions.txt"), "UTF-8"));
		for (Entry<Integer, String> entry: questionList.entrySet() ) 	
		{
			out.write(entry.getValue()+"\n");
			out.flush();
			out.write("\n");
			out.flush();
		}

		out.close();
	}
}
