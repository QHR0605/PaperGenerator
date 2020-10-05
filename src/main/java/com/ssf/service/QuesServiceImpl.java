package com.ssf.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssf.util.db.FileInputUtil;
import com.ssf.util.json.*;

/**
 * 生成题目服务
 * 向controller提供服务接口
 * 调用dao层提供的数据交互接口
 * @author 全鸿润
 *
 */
@Service
public class QuesServiceImpl implements QuesService {

	
	public QuesAndAnswersJson MakeQues(int level, int numbers) throws Exception {

		Map<String, String> map = new HashMap<String, String>();
		QuesAndAnswersJson json = new QuesAndAnswersJson();
		if (level==0) {
			map = FileInputUtil.GetPrimaryQuestionFromDB("小学");
		}else if (level==1) {
			map = FileInputUtil.GetPrimaryQuestionFromDB("初中");
		}else if (level==2) {
			map = FileInputUtil.GetPrimaryQuestionFromDB("高中");
		}
		
		json.setM_quesAndanswers(map);
		
		return json;
	}
	
	
	
	
}
