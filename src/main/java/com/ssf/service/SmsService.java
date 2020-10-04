package com.ssf.service;

import com.aliyuncs.CommonResponse;

public interface SmsService {
	
	public CommonResponse sendMessage(String number);
}
