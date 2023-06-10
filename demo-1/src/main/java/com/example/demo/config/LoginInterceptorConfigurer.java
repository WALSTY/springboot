package com.example.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.interceptor.LoginInterceptor;

@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		HandlerInterceptor interceptor = new LoginInterceptor();
		
		List<String> patterns = new ArrayList<>();
		patterns.add("/web/login.html");
		patterns.add("/web/register.html");
		patterns.add("/users/reg");
		patterns.add("/users/login");
		
		registry.addInterceptor(interceptor)
				.addPathPatterns("/**")
				.excludePathPatterns(patterns);
	}
}
