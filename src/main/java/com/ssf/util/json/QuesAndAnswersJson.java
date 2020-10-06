package com.ssf.util.json;

import java.util.Map;

/**
 * map<"题目描述","答案">
 * @author QuesAndAnswerJson
 *
 */
public class QuesAndAnswersJson{
	
	private Map<Integer, String> m_quesAndanswers;

	public Map<Integer, String> getM_quesAndanswers() {
		return m_quesAndanswers;
	}

	public void setM_quesAndanswers(Map<Integer, String> m_quesAndanswers) {
		this.m_quesAndanswers = m_quesAndanswers;
	}
	
}
