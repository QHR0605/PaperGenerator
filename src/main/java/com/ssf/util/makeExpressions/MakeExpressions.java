package com.ssf.util.makeExpressions;

import java.util.ArrayList;  
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.ssf.util.buildTree.*;
import com.ssf.util.insertoperators.*;

public class MakeExpressions 
{
	
	
	/**
	 * 生成小学表达式
	 * @return 小学表达式
	 */

	public static String MakeExpression() 
	{

		Random random = new Random();
		int temp = 0;
		while (temp == 0)
		{
			temp = random.nextInt(4);
		}
		QuestionTree tree = new QuestionTree(temp);
		tree.BuildTree();
		String res = tree.getExpression();
		return res;

	}
	
	/**
	 * 生成初中表达式
	 * @return
	 */
	public static String MakeMiddleExpression() 
	{
			
		String res = MakeExpressions.MakeExpression();
		//插入根号
		String res1 = InsertSquareRoot.InsertSquareRoots(res);
		//插入平方
		return  InsertSquare.InsertSquare(res1);

	}
	
	/**
	 * 生成高中表达式
	 * @return
	 */
	public static String MakeHightExprssion() 
	{
		
		String res = MakeExpressions.MakeExpression();
		String res2 = null;
		int num = new Random().nextInt(3);
			
		String res1 = InsertSquareRoot.InsertSquareRoots(res);
			
		res2 = InsertSquare.InsertSquare(res1);
		
		String res3 = InsertTrigonometrys.InsertTrigonometry(res2);
		
		return res3;
		
	}
}
