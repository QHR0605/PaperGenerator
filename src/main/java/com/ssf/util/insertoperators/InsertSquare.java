package com.ssf.util.insertoperators;

import java.util.LinkedList; 
import java.util.Random;

import com.ssf.util.constant.*;

public class InsertSquare {

	public static String InsertSquare(String expression)
	{
		
		LinkedList<Character> linkedList = new LinkedList<Character>(); //转为集合,便于插入
		LinkedList<Integer> res2 = new LinkedList<Integer>(); //存放要插入根号的位置
		Random random = new Random();  
		int num,count;
		for (Character character : expression.toCharArray()) 
		{
			linkedList.add(character);
		}
		res2.add(linkedList.size());  //最后肯定可以放平方
		for (int i = 0; i < linkedList.size()-1; i++) 
		{
			if (linkedList.get(i) == Constant.c_rightbracket || Character.isDigit(linkedList.get(i))) 
			{

				
					if (!Character.isDigit(linkedList.get(i+1))) 
					{
						res2.add(i+1);
					}

			}
			
		}
		
		while ((count=new Random().nextInt(res2.size()+1))==0) 
		{
			count = new Random().nextInt(res2.size()+1);
		}
		while (count>0) 
		{
			int num1 = random.nextInt(count); //随机选择要插入的位置值
			linkedList.add(res2.get(num1),Constant.c_square);
			for (int i = 0; i < res2.size(); i++) 
			{
				if (res2.get(i)>res2.get(num1))
				{
					res2.set(i, res2.get(i)+1);
				}
			}
			res2.remove(num1);  //该位置值已经插入,去除
			count--;
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		for (Character character : linkedList) 
		{
			stringBuilder.append(character.toString());
		}

		return stringBuilder.toString();
	}
}
