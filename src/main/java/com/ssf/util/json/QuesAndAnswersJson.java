package com.ssf.util.json;

import java.util.Map;

/**
 * map<"��Ŀ","��">
 * @author ȫ����
 *
 */
public class QuesAndAnswersJson extends JsonResult{
	
	private Map<String, String> m_quesAndanswers;

	public Map<String, String> getM_quesAndanswers() {
		return m_quesAndanswers;
	}

	public void setM_quesAndanswers(Map<String, String> m_quesAndanswers) {
		this.m_quesAndanswers = m_quesAndanswers;
	}
	
}