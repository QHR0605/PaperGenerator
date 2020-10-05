package com.ssf.util.check;

import java.util.List;

public class Check {
	
	public static boolean Check(String curQuestion,List<String> questionDB)
	{
		
		for (String string : questionDB) 
		{
			if (curQuestion.equals(string))
			{
				return false;
			}
		}
		return true;
	}
}
