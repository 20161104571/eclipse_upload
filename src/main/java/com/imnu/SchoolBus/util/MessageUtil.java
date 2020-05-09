package com.imnu.SchoolBus.util;

import java.util.Random;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

public class MessageUtil {
	
    @SuppressWarnings("deprecation")
	public static void sendCode(String phone, String code) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", 
        		"LTAI4Fy5xiuVoJugUvTkuWHH", 
        		"J988fAG5pjmfRWQESQmZlNPFFPZZye");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "校车座位预约");
        request.putQueryParameter("TemplateCode", "SMS_186597898");
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + code + "\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
    
	public static String getCode() {
		StringBuilder sber = new StringBuilder();
		for (int i = 0; sber.length() < 6; i++) {
			int num = new Random().nextInt(10);
			sber.append(num);
			System.out.println(i);
		}
		return sber.toString();
	}
}