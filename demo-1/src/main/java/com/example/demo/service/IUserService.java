package com.example.demo.service;

import com.example.demo.entity.User;

public interface IUserService {

	void reg(User user);
	
	User login(String username, String password);
	
	
}
