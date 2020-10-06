package com.ssf.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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
	
	public QuesAndAnswersJson MakeQues(String level, String number) throws Exception {

		Map<Integer, String> map = null;
		QuesAndAnswersJson json = new QuesAndAnswersJson();
		int numbers = Integer.valueOf(number);
		if (level.equals("小学")) {
			map = quesDaoImpl.GetPaper(level, numbers);
		}else if (level.equals("初中")) {
			map = quesDaoImpl.GetPaper(level, numbers);
		}else if (level.equals("高中")) {
			map = quesDaoImpl.GetPaper(level, numbers);
		}
		
		json.setM_quesAndanswers(map);
		
		return json;
	}
	
	public static void main(String[] args) {
		
		QuesServiceImpl serviceImpl = new QuesServiceImpl();
		QuesAndAnswersJson json = null;
		
		try {
			json = serviceImpl.MakeQues("小学", "10");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<Integer,String> map = json.getM_quesAndanswers();
		System.out.println(map.size());
		int size = json.getM_quesAndanswers().size();
		for (int i = 0; i < size; i++) {
			System.out.println(map.get(i));
		}
	}
	
	
	
}
