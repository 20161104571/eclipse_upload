//package com.imnu.SchoolBus.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableWebSecurity
//public class MySecurityConfig extends WebSecurityConfigurerAdapter{
//	
//	@Bean
//	public PasswordEncoder create() {
//		return new BCryptPasswordEncoder();
//	}
//	
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.authorizeRequests() //授权请求
//				.anyRequest().authenticated()
//				.and()
//				.formLogin();
//			//.httpBasic();
//	}
//
//}
