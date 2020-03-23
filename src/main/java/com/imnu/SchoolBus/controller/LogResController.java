package com.imnu.SchoolBus.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.imnu.SchoolBus.pojo.User;
import com.imnu.SchoolBus.service.UserService;
import com.imnu.SchoolBus.util.UUIDUtils;

@Controller
@RequestMapping(value="/")
public class LogResController {

	@Autowired
	private UserService userService; 
	
    @RequestMapping(value = "registerUser")
    public String register(User user, HttpServletRequest request){
        user.setStatus(0);
        String code = UUIDUtils.getUUID() + UUIDUtils.getUUID();
        user.setCode(code);
        userService.register(user);
        return "user/success";
    }
    
    @RequestMapping(value = "checkCode")
    public String checkCode(String code){
        User user = userService.checkCode(code);
        System.out.println(user);
       if (user !=null){
           user.setStatus(1);
           user.setCode("");
           System.out.println(user);
           userService.updateUserStatus(user);
           return "user/success";
       }
        return "user/regist";
    }

    @RequestMapping(value = "loginUser")
    public String login(User user, HttpServletRequest request){
        User u = userService.loginUser(user);
        if (u !=null){
        	request.getSession().setAttribute("users", u);
        	System.out.println("登录的信息是"+u);
        	u.setId(u.getId());
            return "user/index";
        }
        return "user/login";
    }
    
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "user/index";
    }
    
    

}
