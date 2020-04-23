/**
* @Title:   MessageUtil.java  
* @Package: com.imnu.SchoolBus.util
* @author:  ww 
* @date:    2020年3月29
* @version  V1.0
*/
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


/**  
* @ClassName:   MessageUtil
* @Description: 手机验证码发送
* @author: ww
* @date:   2019年12月11日下午11:24:23
* "LTAI4FhvhTKqYmZ3qKcPmcPE", "gQZSqwImbYKkiTVk2lbKuHhRrNHzby"
*/

public class MessageUtil {
	/**
	 * @param phone
	 *            发送到的手机号
	 * @param code
	 *            验证码内容
	 */
    @SuppressWarnings("deprecation")
	public static void sendCode(String phone, String code) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", 
        		"LTAI4FhkMdBjzhEMUTK5Vbou", 
        		"F5kBypJosqTJoM3twkmoi57o5lxUOA");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        //此处放接收验证码的手机号
        request.putQueryParameter("PhoneNumbers", phone);
        //此处放签名名称
        request.putQueryParameter("SignName", "校车座位预约");
        //此处放短信模板
        request.putQueryParameter("TemplateCode", "SMS_186597898");
        //此处放验证码的内容（JSON格式\"表示转义。JSON格式：{"code":"666666"}）
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
    
	/**
	 * @return 随机生成的6位验证码
	 */
	public static String getCode() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; sb.length() < 6; i++) {
			int num = new Random().nextInt(10);
			sb.append(num);
			System.out.println(i);
		}
		return sb.toString();
	}
}