package com.imnu.SchoolBus.controller;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

import javax.naming.AuthenticationException;
import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.support.json.JSONUtils;
import com.imnu.SchoolBus.pojo.User;
import com.imnu.SchoolBus.service.UserService;
import com.imnu.SchoolBus.util.VerifyUtil;



@Controller
@RequestMapping(value="/loginres")
public class LogResController {
	@Autowired   //依赖注入
	private UserService userService; //登录注册service
	/*
	 * @Autowired private ProCCouService proCCouService; //城市三级联动
	 */	@Value("${web-upload-path}")
	private String path;
	 
	 @RequestMapping(value = "/getVerify")
	 public void getVerify(HttpServletRequest request, HttpServletResponse response){
	    response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
	    response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
	    response.setHeader("Cache-Control", "no-cache");
	    response.setDateHeader("Expire", 0);
	    VerifyUtil verifyUtil = new VerifyUtil();
	    //RandomValidateCode randomValidateCode = new RandomValidateCode();
	    try {
	    	verifyUtil.getRandcode(request, response);//输出验证码图片方法
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)    //拦截post提交方法
    public String login(Model model, String userName, String password,String inputStr, HttpSession session) {
        //从session中获取随机数
        String random = (String) session.getAttribute("RANDOMVALIDATECODEKEY");
        User user=userService.selectByUserName(userName);
 
        Subject subject = SecurityUtils.getSubject() ;
        UsernamePasswordToken token = new UsernamePasswordToken(userName,password);
        try {
            if(random.equals(inputStr)){
                subject.login(token);
                model.addAttribute("user", user);
                return  "user/login" ;
            }else {
                model.addAttribute("error","验证码错误");
                return "redirect:/";
            }
 
        } catch (AuthenticationException e) {
            e.printStackTrace();
            model.addAttribute("error","用户名或密码错误");
            return "redirect:/";
        }
    }

	/*
	 * public ModelAndView LoginUser(User user,String checkbox,HttpServletRequest
	 * request) { HttpSession session = request.getSession(true); ModelAndView view
	 * = new ModelAndView(); User loginUser =
	 * userService.LoginUser(user.getUsername(), user.getPassword());
	 * if("on".equals(checkbox)) { if(loginUser==null) {
	 * view.setViewName("redirect:/Login.jsp"); }else {
	 * session.setAttribute("admin", loginUser); //发送到前端数据
	 * view.setViewName("redirect:/center.jsp"); //重定向 } }else { if(loginUser==null)
	 * { view.setViewName("redirect:/Login.jsp"); }else {
	 * session.setAttribute("user", loginUser); //发送到前端数据
	 * view.setViewName("redirect:/center.jsp"); } } return view; }
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

	
	 @RequestMapping(value="/res",method=RequestMethod.POST) 
	 public ModelAndView ResUser(User user,MultipartFile file) {
		//user.setImg(uploadMultipartFile(file)); //上传图片 
		 ModelAndView view = new ModelAndView(); 
		 boolean result = userService.ResUser(user); 
		 if(result) {
			 view.setViewName("redirect:/Login.jsp"); //默认是请求转发 forward(请求转发)redirect(重定向) 
		 }else {
			 view.setViewName("redirect:/register.jsp"); 
			 } 
		 return view; 
	 }
	 
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
	/*
	 * //加载省
	 * 
	 * @RequestMapping(value="/province",method=RequestMethod.POST,produces =
	 * {"application/json;charset=UTF-8"})
	 * 
	 * @ResponseBody public String getProvince() { List<Province> province =
	 * proCCouService.getProvince(); String jsonString =
	 * JSON.toJSONString(province); return jsonString; } //加载市
	 * 
	 * @RequestMapping(value = "/city", method = RequestMethod.POST, produces = {
	 * "application/json;charset=UTF-8" })
	 * 
	 * @ResponseBody public String getCity(String provincecode) { List<City>
	 * cityList = proCCouService.getCity(provincecode); String jsonString =
	 * JSON.toJSONString(cityList); return jsonString; }
	 * 
	 * // 加载区、县
	 * 
	 * @RequestMapping(value = "/county", method = RequestMethod.POST, produces = {
	 * "application/json;charset=UTF-8" })
	 * 
	 * @ResponseBody public String getCounty(String city) { List<Area> areaList =
	 * proCCouService.getArea(city); String jsonString =
	 * JSON.toJSONString(areaList); return jsonString; }
	 */
	
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
