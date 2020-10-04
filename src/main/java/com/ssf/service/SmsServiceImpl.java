package com.ssf.service;

import org.springframework.stereotype.Service;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

@Service
public class SmsServiceImpl implements SmsService {

	public CommonResponse sendMessage(String number) {
		
		DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4G48J6nwv2ADSWppfFMy", "GzGdBCRhupz9mVr9HGFOuNMs8iAHUt");
		IAcsClient client = new DefaultAcsClient(profile);
		
		CommonRequest request = new CommonRequest();
		request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", "15298917738");
        request.putQueryParameter("SignName", "自动生成试卷系统");
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
	public static void main(String[] args) {
		SmsServiceImpl serviceImpl = new SmsServiceImpl();
		CommonResponse response =  serviceImpl.sendMessage("152989717738");
		System.out.println(response.getData());
		
	}
}
