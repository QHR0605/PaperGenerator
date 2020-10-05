package com.ssf.util.insertoperators;

import java.util.LinkedList; 
import java.util.Random;

import com.ssf.util.constant.*;

public class InsertSquareRoot
{

	public static String InsertSquareRoots(String expression)
	{
		
		LinkedList<Character> linkedList = new LinkedList<Character>(); //转为集合,便于插入
		LinkedList<Integer> res1 = new LinkedList<Integer>(); //存放要插入根号的位置
		Random random = new Random();  
		int num,count;
		for (Character character : expression.toCharArray()) 
		{
			linkedList.add(character);
		}

		/**
		 * 规则:根号只能放在(的前面或者是数字的前面
		 */
		res1.add(0); // 第一位肯定可以放根号
		for (int i = 2; i < linkedList.size(); i++) 
		{
			if (linkedList.get(i) == Constant.c_leftbracket || Character.isDigit(linkedList.get(i))) {

				if (!Character.isDigit(linkedList.get(i - 1))) 
				{
					res1.add(i);
				}

			}
		}
		// 随机生成要插入根号的个数
		while ((count = new Random().nextInt(res1.size() + 1)) == 0)
		{
			count = new Random().nextInt(res1.size() + 1);
		}
		/**
		 * 插入该位置之后
		 * 位置值比插入位置大的要+1
		 */
		while (count > 0) 
		{
			int num1 = random.nextInt(res1.size()); // 随机选择要插入的位置值
			linkedList.add(res1.get(num1), Constant.c_squareroot);
			for (int i = 0; i < res1.size(); i++) 
			{
				if (res1.get(i) > res1.get(num1)) 
				{
					res1.set(i, res1.get(i) + 1);
				}
			}
			res1.remove(num1); // 该位置值已经插入,去除
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
