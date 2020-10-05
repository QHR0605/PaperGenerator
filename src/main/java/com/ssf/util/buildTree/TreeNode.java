package com.ssf.util.buildTree;

public class TreeNode
{
		
	private TreeNode m_left;
	private TreeNode m_right;
	private String m_sign;
	
	//���������,������ǰ���ź����Ҳ���������ʽ
	public TreeNode(String sign, TreeNode m_left, TreeNode m_right)
	{
		this.m_sign = sign;
		this.m_right = m_right;
		this.m_left = m_left;
	}
	
	//���������,���Һ���û�в���������ʽ
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
	
	//�ж��Ƿ�ΪҶ�ڵ�
	public boolean IsLeaf()
	{
		if(m_left==null && m_right==null)
		{
			return true;
		}
		
		return false;
	}
	
	/**�ȸ����ʽ��������,�������Ľṹ���õݹ��������
	 * ���ʽһ�㶼���Գ���Ϊ(object1 op1 object2) op2 (object3 op object4)
	 * @return
	 */
	public String TransformToExpression() 
	{
		
		String leftExpression="",righrExpression = "",curExpression = "";
		//����Ҷ�ڵ�,˵���Ǹ�������
		if (!IsLeaf())
		{
			//�ж��������Ǳ��ʽ���ǲ�����
			if(!getM_right().IsLeaf())
			{
				//�����ǰ������Ϊ/
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
		//��Ҷ�ڵ�,Ϊ������
		else 
		{
			
			curExpression = m_sign;
		}
		
		return curExpression;
	}
	
	
}
