package com.imnu.SchoolBus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.imnu.SchoolBus.pojo.Subs;
import com.imnu.SchoolBus.pojo.Trip;
import com.imnu.SchoolBus.service.SubsService;
import com.imnu.SchoolBus.service.TripService;


@Controller
public class SubsController {
	
	@Autowired
	private SubsService subsService;
	
	@Autowired
	private TripService tripService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("getOrderList")
	public String orderList(Model model) {
		List<Subs> subss = subsService.getOrderList();
		model.addAttribute("subss",subss);
		return "admin/order-list";
	}
	
	@RequestMapping("subsTrip")
	public String findSubsTripById(Model model, int tId) {
		Trip trip = tripService.findSubsTripById(tId);
		model.addAttribute("trip", trip);
		return "user/subsDetails";
	}
	
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
	    jsonObject.put("templateid", "432116");
	    //模板对应的参数，参数之间拼接用逗号作为间隔符
	    jsonObject.put("param", "1315,500");
	    //要发送的手机号
	    jsonObject.put("mobile", "15648975168");
	    //用户透传ID，随状态报告返回,可以不填写
	    jsonObject.put("uid","");
	    String json = JSONObject.toJSONString(jsonObject);
	    //使用restTemplate进行访问远程服务
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
	    HttpEntity<String> httpEntity = new HttpEntity<String>(json, headers);
	    String result = restTemplate.postForObject(url, httpEntity, String.class);
		subsService.createOrder(order);
		return null;
	}
}
