package com.ssf.util.insertoperators;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;

public class InsertTrigonometrys 
{
	
	public static String[] m_operators = new String[]{"sin","cos","tan"};
	
	/**
	 * �������Ǻ��������
	 * @param expression
	 * @return
	 */
	
	public static String InsertTrigonometry(String expression) 
	{
		
		Set<Integer> res1 = new HashSet<Integer>(); //��Ų����λ��
		LinkedList<Character> linkedList = new LinkedList<Character>(); //תΪ����,���ڲ���
		Random random = new Random();  
		int num,count;
		for (Character character : expression.toCharArray()) 
		{
			linkedList.add(character);
		}

		
		/*
		 * ����:���Ǻ���ֻ�ܷ���(��ǰ����������ֵ�ǰ������Ǹ���ǰ�����ź�
		 * ����ͳ�ƿ��Բ������Ǻ�����λ��
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
				if (linkedList.get(i)=='��')
				{
					res1.add(i);
					res1.add(i+1);
				}
		}
		// �������Ҫ�������Ǻ����ĸ���
		while ((count = new Random().nextInt(res1.size() + 1)) == 0) 
		{
			count = new Random().nextInt(res1.size() + 1);
		}
		/**
		 * �����λ��֮��
		 * λ��ֵ�Ȳ���λ�ô��Ҫ+1
		 */
		
		Integer[] temp = res1.toArray(new Integer[0]);
		LinkedList<Integer> locatioList = new LinkedList<Integer>();
		for (Integer integer : temp) 
		{
			locatioList.add(integer);
		}
		while (count > 0)
		{
			int num1 = random.nextInt(locatioList.size()); // ���ѡ��Ҫ�����λ��ֵ
			int temp1 = locatioList.get(num1);
			char[] operator = m_operators[new Random().nextInt(m_operators.length)].toCharArray();//�����ȡҪ��������Ǻ���
			for (char c : operator) 
			{
				linkedList.add(locatioList.get(num1), c);
				locatioList.set(num1, locatioList.get(num1)+1); //sin��Ϊs,i,n����
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
