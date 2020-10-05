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
        request.putQueryParameter("SignName", "�Զ������Ծ�ϵͳ");
        request.putQueryParameter("TemplateCode",  "SMS_204116418");
     // �������͡�0����֤�룻1������֪ͨ��2���ƹ���ţ�3������/�۰�̨��Ϣ
        request.putQueryParameter("TemplateType", "0");
        // ģ�����ƣ�����Ϊ1~30���ַ�
        request.putQueryParameter("TemplateName", "�Զ������Ծ�ϵͳ");
        // ģ�����ݣ�����Ϊ1~500���ַ�
        request.putQueryParameter("TemplateContent", "�����������ֻ�ע�ᣬ��֤��Ϊ��${code}��5��������Ч��");
        // ����ģ������˵��
        request.putQueryParameter("Remark", "������վ��������");
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
        // �������͡�0����֤�룻1������֪ͨ��2���ƹ���ţ�3������/�۰�̨��Ϣ
        addSmsTemplateRequest.putQueryParameter("TemplateType", "0");
        // ģ�����ƣ�����Ϊ1~30���ַ�
        addSmsTemplateRequest.putQueryParameter("TemplateName", "���Զ���ģ��");
        // ģ�����ݣ�����Ϊ1~500���ַ�
        addSmsTemplateRequest.putQueryParameter("TemplateContent", "�����������ֻ�ע�ᣬ��֤��Ϊ��${code}��5��������Ч��");
        // ����ģ������˵��
        addSmsTemplateRequest.putQueryParameter("Remark", "����");
        CommonResponse addSmsTemplateResponse = client.getCommonResponse(addSmsTemplateRequest);
        String data = addSmsTemplateResponse.getData();
        // ���������ı��еķ�ת���ַ�
        String sData = data.replaceAll("'\'", "");
        //log_print("addSmsTemplate", sData);
        Gson gson = new Gson();
        // ���ַ���ת��ΪMap���ͣ�ȡTemplateCode�ֶ�ֵ
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
