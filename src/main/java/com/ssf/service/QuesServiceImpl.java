package com.ssf.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssf.dao.QuesDao;
import com.ssf.dao.QuesDaoImpl;
import com.ssf.util.db.FileInputUtil;
import com.ssf.util.json.*;

/**
 * 向下调用dao层接口,向上给controller层提供接口
 * 返回json对象
 * @author 全鸿润
 *
 */
@Service
public class QuesServiceImpl implements QuesService {
	
	
	QuesDaoImpl quesDaoImpl = new QuesDaoImpl();
	
	public QuesAndAnswersJson MakeQues(int level, int numbers) throws Exception {

		Map<String, String> map = new HashMap<String, String>();
		QuesAndAnswersJson json = new QuesAndAnswersJson();
		if (level==0) {
			map = quesDaoImpl.GetPaper("小学", numbers);
		}else if (level==1) {
			map = quesDaoImpl.GetPaper("初中", numbers);
		}else if (level==2) {
			map = quesDaoImpl.GetPaper("高中", numbers);
		}
		
		json.setM_quesAndanswers(map);
		
		return json;
	}
	
	
	
	
}
