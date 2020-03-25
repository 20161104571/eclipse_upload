package com.imnu.SchoolBus.util;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

public class MessageUtil {

	 DefaultProfile profile = DefaultProfile.getProfile("default", "LTAI4FhkMdBjzhEMUTK5Vbou", "F5kBypJosqTJoM3twkmoi57o5lxUOA");
     IAcsClient client = new DefaultAcsClient(profile);

     public String SendMessage(String phone){
         CommonRequest request = new CommonRequest();
         //request.setSysProtocol(ProtocolType.HTTPS);
         request.setMethod(MethodType.POST);
         request.setDomain("dysmsapi.aliyuncs.com");
         request.setVersion("2017-05-25");
         request.setAction("SendSms");
         request.putQueryParameter("phone", phone);//接受验证码的手机号
         request.putQueryParameter("SignName", "校车座位预约");//签名
         request.putQueryParameter("TemplateCode", "SMS_186597898");//模板代码
         request.putQueryParameter("TemplateParam", "{code:"+((int) (Math.random() * 9000 + 1000))+"}");//用户定义的验证码内容
         try {
             CommonResponse response = client.getCommonResponse(request);
             String returnstr = response.getData();
             System.out.println(returnstr);
             JSONObject returnjsonstr = JSONObject.parseObject(returnstr);
             return returnjsonstr.getString("Message");//返回的信息
         } catch (ServerException e) {
             return e.getErrMsg();
         } catch (ClientException e) {
             return e.getErrMsg();
         }
     };

     //查询发送信息
     public   String QuerySendDetails(String phone,String SendDate,String PageSize,String CurrentPage){
         CommonRequest request = new CommonRequest();
         //request.setSysProtocol(ProtocolType.HTTPS);
         request.setMethod(MethodType.POST);
         request.setDomain("dysmsapi.aliyuncs.com");
         request.setVersion("2017-05-25");
         request.setAction("QuerySendDetails");
         request.putQueryParameter("PhoneNumber", phone);
         request.putQueryParameter("SendDate", SendDate);
         request.putQueryParameter("PageSize", PageSize);
         request.putQueryParameter("CurrentPage", CurrentPage);
         try {
             CommonResponse response = client.getCommonResponse(request);
             String returnstr = response.getData();
             System.out.println(returnstr);
             JSONObject returnjsonstr = JSONObject.parseObject(returnstr);
             return returnjsonstr.getString("Message");
         } catch (ServerException e) {
             return e.getErrMsg();
         } catch (ClientException e) {
             return e.getErrMsg();
         }
     }
	
}
