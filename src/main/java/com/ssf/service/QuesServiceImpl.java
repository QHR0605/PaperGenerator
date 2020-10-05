package com.ssf.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssf.util.db.FileInputUtil;
import com.ssf.util.json.*;

/**
 * ������Ŀ����
 * ��controller�ṩ����ӿ�
 * ����dao���ṩ�����ݽ����ӿ�
 * @author ȫ����
 *
 */
@Service
public class QuesServiceImpl implements QuesService {

	
	public QuesAndAnswersJson MakeQues(int level, int numbers) throws Exception {

		Map<String, String> map = new HashMap<String, String>();
		QuesAndAnswersJson json = new QuesAndAnswersJson();
		if (level==0) {
			map = FileInputUtil.GetPrimaryQuestionFromDB("Сѧ");
		}else if (level==1) {
			map = FileInputUtil.GetPrimaryQuestionFromDB("����");
		}else if (level==2) {
			map = FileInputUtil.GetPrimaryQuestionFromDB("����");
		}
		
		json.setM_quesAndanswers(map);
		
		return json;
	}
	
	
	
	
}
