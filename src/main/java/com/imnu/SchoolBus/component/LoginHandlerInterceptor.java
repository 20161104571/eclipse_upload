package com.imnu.SchoolBus.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginHandlerInterceptor implements HandlerInterceptor{
	
	//目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        //Object A_user = request.getSession().getAttribute("loginAdmin");
        if(user == null){
        	request.setAttribute("name", "没有权限，请登录后再试");
        	request.getRequestDispatcher("/login").forward(request, response);
        	return false;
            //未登录,返回登录页面
//            if(A_user != null){
//                //管理员已登录，放行请求
//                return true;
//            }
//            request.setAttribute("emsg","没有权限，请登录后再试");
//            request.getRequestDispatcher("/adminLogin.html").forward(request,response);
//            return false;
        } else{
            //已登录，放行请求
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
