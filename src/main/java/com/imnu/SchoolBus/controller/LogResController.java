package com.imnu.SchoolBus.controller;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.support.json.JSONUtils;
import com.imnu.SchoolBus.pojo.User;
import com.imnu.SchoolBus.service.UserService;



@Controller
@RequestMapping(value="/loginres")
public class LogResController {
	@Autowired   //依赖注入
	private UserService userService; //登录注册service
	
	@Value("${web-upload-path}")
	private String path;
	 

	/*
	 * public ModelAndView LoginUser(User user,String checkbox,HttpServletRequestrequest) { 
	 * HttpSession session = request.getSession(true); 
	 * ModelAndView view = new ModelAndView(); 
	 * User loginUser = userService.LoginUser(user.getUsername(), user.getPassword());
	 * if("on".equals(checkbox)) { 
	 * if(loginUser==null) {
	 * view.setViewName("redirect:/Login.jsp"); 
	 * }else {
	 * session.setAttribute("admin", loginUser); //发送到前端数据
	 * view.setViewName("redirect:/center.jsp"); //重定向 
	 * } 
	 * }else {
	 *  if(loginUser==null){ 
	 *  view.setViewName("redirect:/Login.jsp");
	 *   }else {
	 * session.setAttribute("user", loginUser); //发送到前端数据
	 * view.setViewName("redirect:/center.jsp"); 
	 * } 
	 * } 
	 * return view; 
	 * }
	 */
	
	/*
	 * @RequestMapping("/verEmail",method=RequestMethod.POST) public ModelAndView
	 * verEmail(User user ,MultipartFile img1,HttpSession session) {
	 * 
	 * String result=uploadMultipartFile(img1); System.out.println(result);
	 * ModelAndView mv = new ModelAndView(); mv.setViewName("login");
	 * if(result!="error") { userService.verEmail(user); } else {
	 * mv.addObject("result",result); } return mv; }
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView longin(User user, HttpSession session) {
		User u = userService.login(user); 
		ModelAndView mv = new ModelAndView();
		if(u==null) {
			mv.setViewName("login");
		}else if(user.getUsername().equals("admin")) {
 			mv.setViewName("admin/index");	
 		}else {
 			mv.setViewName("index");
 		}
 		return mv;
		}

	/*
	 * else { session.setAttribute("sessionuser", u); mv.addObject("user",u);
	 * mv.setViewName("index"); return mv;
	 */

	@RequestMapping(value="/res",method=RequestMethod.POST)
	public ModelAndView regist(User user,MultipartFile img1,HttpSession sesssion) {
		//uploadMultipartFile(img1);
		ModelAndView mv = new ModelAndView();
		boolean result = userService.ResUser(user);
		mv.setViewName("login");
		if(result) {
			//mv.setViewName("login");  
			mv.setViewName("mailvalidation");
		}else {
			mv.setViewName("register");
		}
		return mv; 
	}
	
	/*
	 * @RequestMapping(value="/res",method=RequestMethod.POST) public ModelAndView
	 * ResUser(User user,MultipartFile file) {
	 * //user.setImg(uploadMultipartFile(file)); //上传图片 ModelAndView view = new
	 * ModelAndView(); boolean result = userService.ResUser(user); if(result) {
	 * view.setViewName("redirect:/login.jsp"); //默认是请求转发 forward(请求转发)redirect(重定向)
	 * }else { view.setViewName("redirect:/register.jsp"); } return view; }
	 */
	 
	//produces属性可以设置返回数据的类型以及编码，可以是json或者xml
	@RequestMapping(value="/validate",method=RequestMethod.POST,produces = {"text/html;charset=utf-8"})
	@ResponseBody
	public String validateUser(User user,HttpServletResponse response) {
		boolean result = userService.ValidateUser(user);
		HashMap<String,String> map = new HashMap<String,String>();
		if(result) {
			map.put("result","true");
			map.put("msg","用户名可用");
		}else {
			map.put("result","false");
			map.put("msg","用户名已存在");
		}
//		response.setCharacterEncoding("UTF-8");
//      response.setContentType("text/html;charset=UTF-8");
		String jsonString = JSONUtils.toJSONString(map);  //需要导入Fastjson依赖 将map数据转换为json数据
		return jsonString;
	}
	
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public String uploadMultipartFile(MultipartFile img){
		String filename = img.getOriginalFilename();//获取源文件名
		String suffix = filename.substring(filename.lastIndexOf("."));//扩展名
		String fileNewName=UUID.randomUUID().toString()+suffix;
		File dest = new File(path,fileNewName);
		try {
			img.transferTo(dest);
			return fileNewName;
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
