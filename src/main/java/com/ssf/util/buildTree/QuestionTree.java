package com.ssf.util.buildTree;

import java.util.LinkedList; 
import java.util.List;
import java.util.Random;

import com.ssf.util.random.*;


public class QuestionTree 
{

	private TreeNode m_root;  //根节点
	private int m_operatornums; //操作符的个数
	private List<TreeNode> m_res = new LinkedList<TreeNode>();//操作符结点的集合

	public QuestionTree(int operatornums)
	{
		this.m_operatornums = operatornums;
	}

	public TreeNode getM_root() 
	{
		return m_root;
	}

	public void setM_root(TreeNode m_root)
	{
		this.m_root = m_root;
	}

	public int getM_operatornums()
	{
		return m_operatornums;
	}

	public void setM_operatornums(int m_operatornums) 
	{
		this.m_operatornums = m_operatornums;
	}
	
	public String getExpression() 
	{
		String res = m_root.TransformToExpression();
		res = res.substring(1, res.length()-1);
		return res;
	}
	
	public int depth() 
	{
		int nums = getM_operatornums();
		int depth = 2; //最简单的表达式1+2需要两层
		while (nums/2>0) 
		{
			depth++;
			nums/=2;
		}
		
		return depth;
	}
	
	public void BuildTree() 
	{
		
		TreeNode leftTree,rightTree,leftnode,rightnode;
		if (m_operatornums==1) 
		{
			leftTree = new TreeNode(String.valueOf(RandomUtil.GetRandombumber(100)), null, null);
			rightTree = new TreeNode(String.valueOf(RandomUtil.GetRandombumber(100)), null, null);
			m_root = new TreeNode(RandomUtil.GetRandomOperator(), leftTree, rightTree);
		}
		else 
		{
			int index = 0;
			int  n = depth()-3; //操作符>1的话，树的深度(层数)至少需要三层;这里得到放置操作数的层
			boolean[] location = RandomUtil.GetRandomLocation(m_operatornums);
			
			m_root = new TreeNode(RandomUtil.GetRandomOperator(), null, null);
			m_res.add(m_root);
			for (int i = 0; i < n; i++) 
			{
				for (int j = 0; j < (int)Math.pow(2, i); j++,index++)
				{
					leftTree = new TreeNode(RandomUtil.GetRandomOperator(),null,null);
					rightTree = new TreeNode(RandomUtil.GetRandomOperator(),null,null);
					m_res.get(j+index).setM_left(leftTree);
					m_res.get(j+index).setM_right(rightTree);
					m_res.add(leftTree);
					m_res.add(rightTree);
					
				}
				
			}
			
			//接下来放置操作数或表达式
			
			for (int i = 0; i < location.length; i++) 
			{
				
				//该位置为操作符结点,即表达式结点
				if (location[i])
				{
					leftnode = new TreeNode(String.valueOf(RandomUtil.GetRandombumber(100)), null, null);
					rightnode = new TreeNode(String.valueOf(RandomUtil.GetRandombumber(100)), null, null);
					//左子结点的位置为2*index
					if(i%2==0) 
					{
						leftTree = new TreeNode(RandomUtil.GetRandomOperator(), leftnode, rightnode);
						m_res.add(leftTree);
						m_res.get(index).setM_left(leftTree);
					}
					//右节点的位置
					else
					{
						rightTree = new TreeNode(RandomUtil.GetRandomOperator(), leftnode, rightnode);
						m_res.add(rightTree);
						m_res.get(index).setM_right(rightTree);
					}
				}
				//该位置为操作数结点,左右孩子都为空
				else
				{
					if (i%2==0) 
					{
						leftTree = new TreeNode(String.valueOf(RandomUtil.GetRandombumber(100)), null, null);
						m_res.get(index).setM_left(leftTree);
					}else 
					{
						rightTree = new TreeNode(String.valueOf(RandomUtil.GetRandombumber(100)), null, null);
						m_res.get(index).setM_right(rightTree);
					}
				}
				
				index +=i%2; 
				
			}
			
		}
	}
	
	
}
