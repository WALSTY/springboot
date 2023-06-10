package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import com.example.demo.util.JsonResult;

import jakarta.servlet.http.HttpSession;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("users")
public class UserController extends BaseController{

	@Autowired
	private IUserService userService;
	
	@RequestMapping("reg")
	public JsonResult<Void> reg(User user) {
		
		userService.reg(user);
		return new JsonResult<>(OK);
	}
	
	@RequestMapping("login")
	public JsonResult<User> login(String username, String password,
			HttpSession session){
		
		User data = userService.login(username, password);
		
		session.setAttribute("uid", data.getUid());
		session.setAttribute("username", data.getUsername());
		
		System.out.println(getuidFromSession(session));
		System.out.println(getUsernameFromSession(session));
		
		return new JsonResult<User>(OK, data);
	}
}
