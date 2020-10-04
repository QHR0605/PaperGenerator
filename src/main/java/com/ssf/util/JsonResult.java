package com.ssf.util;

public class JsonResult {

	public int state; // 状态码
	public String message; // 提示信息

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
