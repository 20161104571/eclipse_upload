package com.imnu.SchoolBus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imnu.SchoolBus.pojo.User;
import com.imnu.SchoolBus.service.UserService;
import com.imnu.SchoolBus.util.UUIDUtils;
import com.imnu.SchoolBus.util.VerCodeGenerateUtil;

@Controller
@RequestMapping(value="/loginres")
public class LogResController {

	@Autowired
	private UserService userService; //登录注册service
	
//	@Value("${web-upload-path}")
//	private String path;
	 
	/**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping(value = "/registerUser")
    
    public String register(User user){
        user.setStatus(0);
        String code = UUIDUtils.getUUID() + UUIDUtils.getUUID();
        //String code = VerCodeGenerateUtil.generateVerCode();
        user.setCode(code);
        userService.register(user);
        return "user/success";
    }
    

    /**
     *校验邮箱中的code激活账户
     * 首先根据激活码code查询用户，之后再把状态修改为"1"
     */
    @RequestMapping(value = "/checkCode")
    @ResponseBody
    public String checkCode(String code){
        User user = userService.checkCode(code);
        System.out.println(user);
        //如果用户不等于null，把用户状态修改status=1
       if (user !=null){
           user.setStatus(1);
           //把code验证码清空，已经不需要了
           user.setCode("");
           System.out.println(user);
           userService.updateUserStatus(user);
       }
        return "user/login";
    }

    /**
     * 跳转到登录页面
     * @return login
     */
    @RequestMapping(value = "/loginPage")
    @ResponseBody
    public String login(){
        return "user/login";
    }

    /**
     * 登录
     */
    @RequestMapping(value = "/loginUser")
    @ResponseBody
    public String login(User user, Model model){
        User u = userService.loginUser(user);
        if (u !=null){
            return "user/welcome";
        }
        return "user/login";
    }
	
//	@RequestMapping(value="/login",method=RequestMethod.POST)
//	public ModelAndView longin(User user, HttpSession session) {
//		User u = userService.login(user); 
//		ModelAndView mv = new ModelAndView();
//		if(u==null) {
//			mv.setViewName("login");
//		}else if(user.getUsername().equals("admin")) {
// 			mv.setViewName("admin/index");	
// 		}else {
// 			mv.setViewName("index");
// 		}
// 		return mv;
//		}
//
//
//	@RequestMapping(value="/res",method=RequestMethod.POST)
//	public ModelAndView regist(User user,MultipartFile img1,HttpSession sesssion) {
//		//uploadMultipartFile(img1);
//		ModelAndView mv = new ModelAndView();
//		boolean result = userService.ResUser(user);
//		mv.setViewName("login");
//		if(result) {
//			//mv.setViewName("login");  
//			mv.setViewName("mailvalidation");
//		}else {
//			mv.setViewName("register");
//		}
//		return mv; 
//	}
	
	
	
	/*
	 * @RequestMapping(value="/res",method=RequestMethod.POST) public ModelAndView
	 * ResUser(User user,MultipartFile file) {
	 * //user.setImg(uploadMultipartFile(file)); //上传图片 ModelAndView view = new
	 * ModelAndView(); boolean result = userService.ResUser(user); if(result) {
	 * view.setViewName("redirect:/login.jsp"); //默认是请求转发 forward(请求转发)redirect(重定向)
	 * }else { view.setViewName("redirect:/register.jsp"); } return view; }
	 */
	 
	//produces属性可以设置返回数据的类型以及编码，可以是json或者xml
//	@RequestMapping(value="/validate",method=RequestMethod.POST,produces = {"text/html;charset=utf-8"})
//	@ResponseBody
//	public String validateUser(User user,HttpServletResponse response) {
//		boolean result = userService.ValidateUser(user);
//		HashMap<String,String> map = new HashMap<String,String>();
//		if(result) {
//			map.put("result","true");
//			map.put("msg","用户名可用");
//		}else {
//			map.put("result","false");
//			map.put("msg","用户名已存在");
//		}
////		response.setCharacterEncoding("UTF-8");
////      response.setContentType("text/html;charset=UTF-8");
//		String jsonString = JSONUtils.toJSONString(map);  //需要导入Fastjson依赖 将map数据转换为json数据
//		return jsonString;
//	}
//	
//	
//	@RequestMapping(value = "/upload", method = RequestMethod.POST)
//	@ResponseBody
//	public String uploadMultipartFile(MultipartFile img){
//		String filename = img.getOriginalFilename();//获取源文件名
//		String suffix = filename.substring(filename.lastIndexOf("."));//扩展名
//		String fileNewName=UUID.randomUUID().toString()+suffix;
//		File dest = new File(path,fileNewName);
//		try {
//			img.transferTo(dest);
//			return fileNewName;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "error";
//		}
//	}
}
