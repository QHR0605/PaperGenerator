package com.ssf.util.random;

import java.util.Random; 

import com.ssf.util.constant.*;;

/**
 * 该模块功能为随机生成操作数、操作符、以及它们的随机位置
 * @author 全鸿润
 *
 */
public class RandomUtil 
{
	
	/**
	 * 随机生成操作数
	 * @param target
	 * @return res
	 */
	public static int GetRandombumber(int target) 
	{
		
		Random random = new Random();
		int res = random.nextInt(target+1); //1~target
		while (res==0) 
		{
			res = random.nextInt(target+1);
		}
		
		return res;
		
	}
	
	
	/**
	 * 
	 * 随机生成操作符
	 */
	
	public static String GetRandomOperator() 
	{
		String operator = "";
		Random random = new Random();
		int number = random.nextInt(4); //+-*/
		
		switch (number) 
		{
		case 0:
			operator+=Constant.c_add;
			break;
		case 1:
			operator+=Constant.c_sub;
			break;
		case 2:
			operator+=Constant.c_mul;
			break;
		case 3:
			operator+=Constant.c_divide;
			break;
		default:
			break;
		}
		
		return operator;
	}
	
	/**
	 * 随机生成操作数结点或表达式结点的位置
	 * @param operatornums
	 * @return
	 */
	public static boolean[] GetRandomLocation(int operatornums)
	{
		
		//确定操作符个数为operatornums时，构建后缀表达式需要多少了子节点
		//确定后缀表达式树的层数
		int levels = 1;
		while ((int)Math.pow(2, levels)<=operatornums) 
		{
			levels++;
		}
		//确定结点个数
		int size = (int)Math.pow(2, levels-1);
		//确定除了操作符结点之外,该层的操作数结点
		int numNode = (int)Math.pow(2,levels)-1-operatornums;
		//初始化
		boolean[] type = new boolean[size];
		for (int i = 0; i < type.length; i++) 
		{
			type[i] = true; //初始为全是表达式结点
		}
		
		//生成操作数结点的位置
		for (int i = 0; i < numNode; i++) 
		{
			
			Random random = new Random();
			int index = random.nextInt(size);
			//遇到操作符结点改为操作数结点
			while (type[index]==false) 
			{
				index = random.nextInt(size);
			}
			type[index] = false;
			
		}
		
		return type;
	}
}
