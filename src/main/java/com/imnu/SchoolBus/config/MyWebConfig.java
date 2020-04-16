package com.imnu.SchoolBus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.imnu.SchoolBus.component.LoginHandlerInterceptor;
import com.imnu.SchoolBus.component.MyLocaleResolver;

@Configuration
public class MyWebConfig implements WebMvcConfigurer{
	
	@Bean//将组件注册在容器中
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer adapter = new WebMvcConfigurer() {
            
            //拦截器注册，addPathPatterns()添加拦截请求，excludePathPatterns()排除拦截请求
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).
                        addPathPatterns(
                        		"/personcenter.html",
                                "/personcenter1.html",
                                "/personcenter2.html",
                                "/personcenter3.html",
                                "/aindex.html").
                        excludePathPatterns("/","/adminLogin.html",
                                
                                "/user/login",
                                "/user/regist",
                                "/index.html",
                                "/index2.html",
                                "/404.html",
                                "public.html");
            }
        };
        return adapter;
    }

    //国际化配置
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

}
