package com.imnu.SchoolBus.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imnu.SchoolBus.pojo.Notice;
import com.imnu.SchoolBus.pojo.Trip;
import com.imnu.SchoolBus.pojo.User;
import com.imnu.SchoolBus.service.NoticeService;
import com.imnu.SchoolBus.service.TripService;
import com.imnu.SchoolBus.service.UserService;
import com.imnu.SchoolBus.util.UUIDUtils;

@Controller
@RequestMapping(value="/")
public class LogResController {

	@Autowired
	private UserService userService; 
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private TripService tripService;
	
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
        return "user/login";
    }

    @RequestMapping(value = "loginUser")
    public String login(User user, HttpServletRequest request, Model model, String nowDate, String nowTime){
    	SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
    	SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
    	Date date = new Date();
    	nowDate = (String)format1.format(date);
    	nowTime = (String)format2.format(date);
    	List<Notice> notice = noticeService.getNoticeList();
    	List<Trip> t = tripService.getTripsList();
    	User u = userService.loginUser(user);
        if (u !=null){
        	request.getSession().setAttribute("users", u);
        	System.out.println("登录的信息是"+u);
        	model.addAttribute("notice", notice);
        	model.addAttribute("t", t);
        	model.addAttribute("nowDate", nowDate);
        	model.addAttribute("nowTime", nowTime);
            return "user/index";
        }
        return "user/login";
    }
    
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request, Model model, Integer nId, String nowDate, String nowTime){
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		nowDate = (String)format1.format(date); 
		nowTime = (String)format2.format(date);
		List<Notice> notice = noticeService.getNoticeList();
		List<Trip> trip = tripService.getTripsList();
		request.getSession().invalidate();
		model.addAttribute("notice", notice);
		model.addAttribute("t", trip);
		model.addAttribute("nowDate", nowDate);
		model.addAttribute("nowTime", nowTime);
        return "user/index";
    }
    
    @RequestMapping("checkUserName")
	@ResponseBody
	public String checkUserName(String username) {
		boolean isExist = userService.findUserByUsername(username);
		return "{\"isExist\":"+isExist+"}";
		
	}
    
    @RequestMapping("checkPhone")
    @ResponseBody
    public String checkPhone(String phone) {
    	boolean isPhone = userService.findUserByPhone(phone);
    	return "{\"isPhone\":"+isPhone+"}";
    }
    
    @RequestMapping("checkEmail")
    @ResponseBody
    public String checkEmail(String email) {
    	boolean isEmail = userService.findUserByEmail(email);
    	return "{\"isEmail\":"+isEmail+"}";
    }
    
    @RequestMapping("checkOldPwd")
    @ResponseBody
    public void checkOldPwd(int id, String password, HttpServletResponse response) throws IOException {
    	boolean isOldPwd = userService.findUserPwd(id,password);
    	PrintWriter out = response.getWriter();
    	if(isOldPwd==true) {
    		out.print(1);
    	}else if(isOldPwd==false) {
    		out.print(2);
    	}
    }
    
    @RequestMapping("checkStuNum")
    @ResponseBody
    public void checkStuNum(String stuname, String stunum, HttpServletResponse response) throws IOException {
    	boolean u = userService.findStuByNameAndNum(stuname, stunum);
    	PrintWriter out = response.getWriter();
    	if(u==true) {
    		out.print(1);
    	}else if(u==false){
    		out.print(2);
    	}
    }
}
