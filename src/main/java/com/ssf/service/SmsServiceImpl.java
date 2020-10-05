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

	DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4G48J6nwv2ADSWppfFMy", "GzGdBCRhupz9mVr9HGFOuNMs8iAHUt");
	IAcsClient client = new DefaultAcsClient(profile);
	String templateCode  = null;
	public CommonResponse sendMessage(String number) {
		
		String verifycode = String.valueOf(new Random().nextInt(899999)+100000);
		CommonRequest request = new CommonRequest();
		request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", number);
        request.putQueryParameter("SignName", "自动生成试卷系统");
        request.putQueryParameter("TemplateCode",  "SMS_204116418");
     // 短信类型。0：验证码；1：短信通知；2：推广短信；3：国际/港澳台消息
        request.putQueryParameter("TemplateType", "0");
        // 模板名称，长度为1~30个字符
        request.putQueryParameter("TemplateName", "自动生成试卷系统");
        // 模板内容，长度为1~500个字符
        request.putQueryParameter("TemplateContent", "您正在申请手机注册，验证码为：${code}，5分钟内有效！");
        // 短信模板申请说明
        request.putQueryParameter("Remark", "个人网站开发测试");
        request.putQueryParameter("TemplateParam", "{\"code\":\"2222\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            return response;
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        
        return null;
	}
	
	/*
	private String addTemplate() throws ServerException, ClientException {
		CommonRequest addSmsTemplateRequest = new CommonRequest();
        addSmsTemplateRequest.setSysDomain("dysmsapi.aliyuncs.com");
        addSmsTemplateRequest.setSysAction("AddSmsTemplate");
        addSmsTemplateRequest.setSysVersion("2017-05-25");
        // 短信类型。0：验证码；1：短信通知；2：推广短信；3：国际/港澳台消息
        addSmsTemplateRequest.putQueryParameter("TemplateType", "0");
        // 模板名称，长度为1~30个字符
        addSmsTemplateRequest.putQueryParameter("TemplateName", "测试短信模板");
        // 模板内容，长度为1~500个字符
        addSmsTemplateRequest.putQueryParameter("TemplateContent", "您正在申请手机注册，验证码为：${code}，5分钟内有效！");
        // 短信模板申请说明
        addSmsTemplateRequest.putQueryParameter("Remark", "测试");
        CommonResponse addSmsTemplateResponse = client.getCommonResponse(addSmsTemplateRequest);
        String data = addSmsTemplateResponse.getData();
        // 消除返回文本中的反转义字符
        String sData = data.replaceAll("'\'", "");
        //log_print("addSmsTemplate", sData);
        Gson gson = new Gson();
        // 将字符串转换为Map类型，取TemplateCode字段值
        Map map = gson.fromJson(sData, Map.class);
        Object templateCode = map.get("TemplateCode");
        return templateCode.toString();
	}*/
	public static void main(String[] args) throws Exception, ClientException {
		
		SmsServiceImpl serviceImpl = new SmsServiceImpl();
		
		//String templateCode = serviceImpl.addTemplate();
		CommonResponse response =  serviceImpl.sendMessage("15298917738");
		System.out.println(response.getData());
		
	}
}
