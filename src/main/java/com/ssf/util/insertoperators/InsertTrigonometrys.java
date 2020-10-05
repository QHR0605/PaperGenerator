package com.ssf.util.insertoperators;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;

public class InsertTrigonometrys 
{
	
	public static String[] m_operators = new String[]{"sin","cos","tan"};
	
	/**
	 * 插入三角函数运算符
	 * @param expression
	 * @return
	 */
	
	public static String InsertTrigonometry(String expression) 
	{
		
		Set<Integer> res1 = new HashSet<Integer>(); //存放插入的位置
		LinkedList<Character> linkedList = new LinkedList<Character>(); //转为集合,便于插入
		Random random = new Random();  
		int num,count;
		for (Character character : expression.toCharArray()) 
		{
			linkedList.add(character);
		}

		
		/*
		 * 规则:三角函数只能放在(的前面或者是数字的前面或者是根号前面或根号后
		 * 这里统计可以插入三角函数的位置
		 */
		res1.add(0);
		for (int i = 2; i < linkedList.size(); i++) 
		{
			
				if (!Character.isDigit(linkedList.get(i - 1))&& Character.isDigit(linkedList.get(i))) 
				{
					res1.add(i);
				}
				if (linkedList.get(i) == '(')
				{
					res1.add(i);
				}
				if (linkedList.get(i)=='√')
				{
					res1.add(i);
					res1.add(i+1);
				}
		}
		// 随机生成要插入三角函数的个数
		while ((count = new Random().nextInt(res1.size() + 1)) == 0) 
		{
			count = new Random().nextInt(res1.size() + 1);
		}
		/**
		 * 插入该位置之后
		 * 位置值比插入位置大的要+1
		 */
		
		Integer[] temp = res1.toArray(new Integer[0]);
		LinkedList<Integer> locatioList = new LinkedList<Integer>();
		for (Integer integer : temp) 
		{
			locatioList.add(integer);
		}
		while (count > 0)
		{
			int num1 = random.nextInt(locatioList.size()); // 随机选择要插入的位置值
			int temp1 = locatioList.get(num1);
			char[] operator = m_operators[new Random().nextInt(m_operators.length)].toCharArray();//随机获取要插入的三角函数
			for (char c : operator) 
			{
				linkedList.add(locatioList.get(num1), c);
				locatioList.set(num1, locatioList.get(num1)+1); //sin分为s,i,n插入
			}
			locatioList.remove(num1);
			for (int i = 0; i < locatioList.size(); i++) 
			{
				if (locatioList.get(i) >= temp1) 
				{
					locatioList.set(i, locatioList.get(i) + 3);
				}
			}
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
