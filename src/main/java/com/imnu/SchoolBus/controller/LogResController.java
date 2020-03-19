package com.imnu.SchoolBus.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imnu.SchoolBus.pojo.User;
import com.imnu.SchoolBus.service.UserService;
import com.imnu.SchoolBus.util.VerCodeGenerateUtil;

@Controller
@RequestMapping(value="/")
public class LogResController {

	@Autowired
	private UserService userService; 
	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
//	@Value("${web-upload-path}")
//	private String path;
	
	@RequestMapping(value="sendEmailCode")
	public String sendCode(String email, HttpSession session) {
		String code = VerCodeGenerateUtil.generateVerCode();
		System.out.println(code);
		session.setAttribute("code", code);
		return code;
	}
	/**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping(value = "registerUser")
    public String register(User user){
        //user.setStatus(0);
        //String code = UUIDUtils.getUUID() + UUIDUtils.getUUID();
        //String code = VerCodeGenerateUtil.generateVerCode();
        //user.setCode(code);
        userService.register(user);
        //String password = passwordEncoder.encode(user.getPassword());
        //System.out.println("验证后密码是："+password);
        return "user/success";
    }
    

    /**
     *校验邮箱中的code激活账户
     * 首先根据激活码code查询用户，之后再把状态修改为"1"
     */
    @RequestMapping(value = "checkCode")
    public String checkCode(String code){
        User user = userService.checkCode(code);
        System.out.println(user);
        //如果用户不等于null，把用户状态修改status=1
       if (user !=null){
           //user.setStatus(1);
           //把code验证码清空，已经不需要了
           //user.setCode("");
           System.out.println(user);
           userService.updateUserStatus(user);
       }
        return "user/login";
    }

    /**
     * 登录
     */
    @RequestMapping(value = "loginUser")
    public String login(User user, HttpServletRequest request){
        User u = userService.loginUser(user);
        if (u !=null){
        	request.getSession().setAttribute("users", u);
        	System.out.println("登录的信息是"+u);
        	//String uid = userService.findUserById(id);
        	u.setId(u.getId());
            return "user/index";
        }
        return "user/login";
    }
    
    

}
