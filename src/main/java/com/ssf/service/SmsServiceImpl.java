package com.ssf.service;

import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;

@Service
public class SmsServiceImpl implements SmsService {

	DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "YourAccessKey", "YourAccessScrete");
	IAcsClient client = new DefaultAcsClient(profile);
	String templateCode  = null;
	public CommonResponse sendMessage(String number,String verifycode) {
		
		CommonRequest request = new CommonRequest();
		request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", number);
        request.putQueryParameter("SignName", "自动生成试卷系统");
        request.putQueryParameter("TemplateCode",  "Your TemplateCode");
        //0为验证码形式
        request.putQueryParameter("TemplateType", "0");
        request.putQueryParameter("TemplateName", "自动生成试卷系统");
        request.putQueryParameter("TemplateContent", "您正在申请手机注册，验证码为：${code}，5分钟内有效！");
        request.putQueryParameter("Remark", "个人网站开发测试");
        //这里设定验证码为2222
        request.putQueryParameter("TemplateParam", "{\"code\":\"2222\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            return response;
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        
        return null;
	}
}
