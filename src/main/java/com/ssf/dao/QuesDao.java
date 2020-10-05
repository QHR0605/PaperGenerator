package com.ssf.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.ssf.util.db.FileInputUtil;
import com.ssf.util.json.QuesAndAnswersJson;


public interface QuesDao {
	
	
	public Map<Integer, String> GetPaper(String level,int numbers) throws IOException;
}
