package com.ssf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssf.service.QuesServiceImpl;
import com.ssf.util.json.*;

/**
 * ������ȥ�����������Ŀ�Ļ���
 * ֱ�ӽ����ļ���ȡ��Ŀ�Ͷ�Ӧ��
 * @author ȫ����
 *
 */
@Controller
public class MakeQuestionController {
	
	@Autowired
	QuesServiceImpl quesService;
	
	
	/**
	 * �����ļ�������ȡ����������
	 * ��ȥ��
	 * @return
	 */
	@RequestMapping("makequestion.do")
	@ResponseBody
	public QuesAndAnswersJson MakeQues(int level , int number) {
		
		if (level==0) {
			
		}else if (level==1) {
			
		}else if (level==2) {
			
		}
		return null;
		
		
	}
}
