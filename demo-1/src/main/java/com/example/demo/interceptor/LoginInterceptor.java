package com.example.demo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		Object obj = request.getSession().getAttribute("uid");
		if(obj == null) {
			response.sendRedirect("/web/login.html");
			return false;
		}
		
		return true;
		
	}
}
