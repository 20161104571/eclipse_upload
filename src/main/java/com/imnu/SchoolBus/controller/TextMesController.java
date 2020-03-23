package com.imnu.SchoolBus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.imnu.SchoolBus.pojo.Subs;

@RestController
@RequestMapping("sms")
public class TextMesController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	//@Autowired
	//private SubsService subsService;
	
	@SuppressWarnings("deprecation")
	@RequestMapping("getSubsPhoneText")
	public String createSubsTrip(Subs order) {
		//单发短信API
	    String url = "https://open.ucpaas.com/ol/sms/sendsms";
	    JSONObject jsonObject = new JSONObject();
	    //基础配置，在开发平台认证后获取
	    jsonObject.put("sid","1034cfd4657a92a95d57c7d9db992756");
	    jsonObject.put("token","82a73011c5235c45fdf0678039149bb8");
	    jsonObject.put("appid","6ad8a3cbf73b436586e0f8fc7024e47b");
	    //模板ID，在开发平台创建模板对应的模板ID
	    jsonObject.put("templateid", "534939");
	    //模板对应的参数，参数之间拼接用逗号作为间隔符
	    jsonObject.put("param", "");
	    //要发送的手机号
	    jsonObject.put("mobile", "17678018037");
	    //用户透传ID，随状态报告返回,可以不填写
	    jsonObject.put("uid","");
	    String json = JSONObject.toJSONString(jsonObject);
	    //使用restTemplate进行访问远程服务
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
	    HttpEntity<String> httpEntity = new HttpEntity<String>(json, headers);
	    String result = restTemplate.postForObject(url, httpEntity, String.class);
		//subsService.createOrder(order);
		return result;
	}

}
