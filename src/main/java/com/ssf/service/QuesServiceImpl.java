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
			map = quesDaoImpl.GetPaper("初中", numbers);
		}else if (level.equals("高中")) {
			map = quesDaoImpl.GetPaper("高中", numbers);
		}
		
		json.setM_quesAndanswers(map);
		
		return json;
	}
	
	public static void main(String[] args) throws Exception {
		
		QuesServiceImpl serviceImpl = new QuesServiceImpl();
		QuesAndAnswersJson json =  serviceImpl.MakeQues("高中", "10");
		Map<Integer,String> map = json.getM_quesAndanswers();
		for (int i = 0; i < json.getM_quesAndanswers().size(); i++) {
			
			System.out.println(map.get(i));
		}
	}
	
	
	
}
