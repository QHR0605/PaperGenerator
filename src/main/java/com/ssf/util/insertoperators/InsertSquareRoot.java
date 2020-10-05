package com.ssf.util.insertoperators;

import java.util.LinkedList; 
import java.util.Random;

import com.ssf.util.constant.*;

public class InsertSquareRoot
{

	public static String InsertSquareRoots(String expression)
	{
		
		LinkedList<Character> linkedList = new LinkedList<Character>(); //תΪ����,���ڲ���
		LinkedList<Integer> res1 = new LinkedList<Integer>(); //���Ҫ������ŵ�λ��
		Random random = new Random();  
		int num,count;
		for (Character character : expression.toCharArray()) 
		{
			linkedList.add(character);
		}

		/**
		 * ����:����ֻ�ܷ���(��ǰ����������ֵ�ǰ��
		 */
		res1.add(0); // ��һλ�϶����ԷŸ���
		for (int i = 2; i < linkedList.size(); i++) 
		{
			if (linkedList.get(i) == Constant.c_leftbracket || Character.isDigit(linkedList.get(i))) {

				if (!Character.isDigit(linkedList.get(i - 1))) 
				{
					res1.add(i);
				}

			}
		}
		// �������Ҫ������ŵĸ���
		while ((count = new Random().nextInt(res1.size() + 1)) == 0)
		{
			count = new Random().nextInt(res1.size() + 1);
		}
		/**
		 * �����λ��֮��
		 * λ��ֵ�Ȳ���λ�ô��Ҫ+1
		 */
		while (count > 0) 
		{
			int num1 = random.nextInt(res1.size()); // ���ѡ��Ҫ�����λ��ֵ
			linkedList.add(res1.get(num1), Constant.c_squareroot);
			for (int i = 0; i < res1.size(); i++) 
			{
				if (res1.get(i) > res1.get(num1)) 
				{
					res1.set(i, res1.get(i) + 1);
				}
			}
			res1.remove(num1); // ��λ��ֵ�Ѿ�����,ȥ��
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
