package com.ssf.util.buildTree;

public class TreeNode
{
		
	private TreeNode m_left;
	private TreeNode m_right;
	private String m_sign;
	
	//操作符结点,包括当前符号和左右操作数或表达式
	public TreeNode(String sign, TreeNode m_left, TreeNode m_right)
	{
		this.m_sign = sign;
		this.m_right = m_right;
		this.m_left = m_left;
	}
	
	//操作数结点,左右孩子没有操作数或表达式
	public TreeNode(String sign) 
	{
		this.m_sign = sign;
	}
	public TreeNode getM_left()
	{
		return m_left;
	}
	public void setM_left(TreeNode m_left) 
	{
		this.m_left = m_left;
	}
	public TreeNode getM_right() 
	{
		return m_right;
	}
	public void setM_right(TreeNode m_right) 
	{
		this.m_right = m_right;
	}
	public String getM_sign()
	{
		return m_sign;
	}
	public void setM_sign(String m_sign) 
	{
		this.m_sign = m_sign;
	}
	
	//判断是否为叶节点
	public boolean IsLeaf()
	{
		if(m_left==null && m_right==null)
		{
			return true;
		}
		
		return false;
	}
	
	/**先给表达式加上括号,根据树的结构采用递归添加括号
	 * 表达式一般都可以抽象为(object1 op1 object2) op2 (object3 op object4)
	 * @return
	 */
	public String TransformToExpression() 
	{
		
		String leftExpression="",righrExpression = "",curExpression = "";
		//不是叶节点,说明是个操作符
		if (!IsLeaf())
		{
			//判断右子树是表达式还是操作数
			if(!getM_right().IsLeaf())
			{
				//如果当前操作符为/
				if(m_sign.equals("/")) 
				{
					righrExpression = getM_right().TransformToExpression();
				}else if (m_sign.equals("*")||m_sign.equals("-"))
				{
					
					if (getM_right().m_sign.equals("+")||getM_right().m_sign.equals("-")) 
					{
						
						righrExpression = getM_right().TransformToExpression();
					}else
					{
						
						righrExpression = getM_right().TransformToExpression().substring(1, getM_right().TransformToExpression().length()-1);
					}
					
				}else
				{
					
					righrExpression = getM_right().TransformToExpression().substring(1, getM_right().TransformToExpression().length()-1);
				}
				
			}
			else 
			{
				
				righrExpression = getM_right().m_sign;
			}
			if (!getM_left().IsLeaf()) 
			{
				
				if (m_sign.equals("*")||m_sign.equals("/")) 
				{
					
					if (getM_left().m_sign.equals("+")||getM_left().m_sign.equals("-"))
					{
						leftExpression = getM_left().TransformToExpression();
					}else 
					{
						leftExpression = getM_left().TransformToExpression().substring(1,getM_left().TransformToExpression().length()-1);
					}
					
				}else 
				{
					leftExpression = getM_left().TransformToExpression().substring(1, getM_left().TransformToExpression().length()-1);
				}
			}else 
			{
				leftExpression = getM_left().m_sign;
			}
			
			curExpression = "("+leftExpression+m_sign+righrExpression+")";
		}
		//是叶节点,为操作数
		else 
		{
			
			curExpression = m_sign;
		}
		
		return curExpression;
	}
	
	
}
