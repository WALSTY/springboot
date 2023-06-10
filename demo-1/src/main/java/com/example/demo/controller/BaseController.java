package com.example.demo.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.service.ex.InsertException;
import com.example.demo.service.ex.PasswordNotMatchException;
import com.example.demo.service.ex.ServiceException;
import com.example.demo.service.ex.UserNotFoundException;
import com.example.demo.service.ex.UsernameDuplicateException;
import com.example.demo.util.JsonResult;

import jakarta.servlet.http.HttpSession;

public class BaseController {

	public static final int OK = 200;
	
	@ExceptionHandler(ServiceException.class)
	public JsonResult<Void> handleException(Throwable e) {
		
		JsonResult<Void> result = new JsonResult<>(e);
		
		if(e instanceof UsernameDuplicateException) {
			result.setState(4000);
			result.setMessage("zanyong");
		}else if(e instanceof UserNotFoundException) {
			result.setState(5001);
			result.setMessage("shujubucunzai");
		}else if(e instanceof PasswordNotMatchException) {
			result.setState(5002);
			result.setMessage("mimacuowu");
		}else if(e instanceof InsertException) {
			result.setState(5000);
			result.setMessage("yichang");
		}
		
		return result;
	}
	
	protected final Integer getuidFromSession(HttpSession session) {
		
		return Integer.valueOf(session.getAttribute("uid").toString());
	}
	
	protected final String getUsernameFromSession(HttpSession session) {
		
		return session.getAttribute("username").toString();
	}
}
