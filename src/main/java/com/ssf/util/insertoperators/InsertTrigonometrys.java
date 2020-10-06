package com.ssf.util.insertoperators;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;

import com.ssf.util.constant.Constant;

public class InsertTrigonometrys 
{
	
	public static String[] m_operators = new String[]{"sin","cos","tan"};
	
	/**
	 * 
	 * @param expression
	 * @return
	 */
	
	public static String InsertTrigonometry(String expression) 
	{
		
		Set<Integer> res1 = new HashSet<Integer>(); 
		LinkedList<Character> linkedList = new LinkedList<Character>(); 
		Random random = new Random();  
		int num,count;
		for (Character character : expression.toCharArray()) 
		{
			linkedList.add(character);
		}

		
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
				if (linkedList.get(i)==Constant.c_squareroot)
				{
					res1.add(i);
					res1.add(i+1);
				}
		}
		while ((count = new Random().nextInt(res1.size() + 1)) == 0) 
		{
			count = new Random().nextInt(res1.size() + 1);
		}
		
		Integer[] temp = res1.toArray(new Integer[0]);
		LinkedList<Integer> locatioList = new LinkedList<Integer>();
		for (Integer integer : temp) 
		{
			locatioList.add(integer);
		}
		while (count > 0)
		{
			int num1 = random.nextInt(locatioList.size()); 
			int temp1 = locatioList.get(num1);
			char[] operator = m_operators[new Random().nextInt(m_operators.length)].toCharArray();//�����ȡҪ��������Ǻ���
			for (char c : operator) 
			{
				linkedList.add(locatioList.get(num1), c);
				locatioList.set(num1, locatioList.get(num1)+1); 
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
