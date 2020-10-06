package com.ssf.util.buildTree;

import java.util.LinkedList; 
import java.util.List;
import java.util.Random;

import com.ssf.util.random.*;


public class QuestionTree 
{

	private TreeNode m_root;  
	private int m_operatornums; 
	private List<TreeNode> m_res = new LinkedList<TreeNode>();

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
		int depth = 2; 
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
			int  n = depth()-3; 
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
			
			
			
			for (int i = 0; i < location.length; i++) 
			{
				
				
				if (location[i])
				{
					leftnode = new TreeNode(String.valueOf(RandomUtil.GetRandombumber(100)), null, null);
					rightnode = new TreeNode(String.valueOf(RandomUtil.GetRandombumber(100)), null, null);
					
					if(i%2==0) 
					{
						leftTree = new TreeNode(RandomUtil.GetRandomOperator(), leftnode, rightnode);
						m_res.add(leftTree);
						m_res.get(index).setM_left(leftTree);
					}
					
					else
					{
						rightTree = new TreeNode(RandomUtil.GetRandomOperator(), leftnode, rightnode);
						m_res.add(rightTree);
						m_res.get(index).setM_right(rightTree);
					}
				}
				
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
