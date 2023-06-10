package com.example.demo.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.User;
import com.example.demo.service.ex.ServiceException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTests {
	
	@Autowired
	private IUserService userService;
	 
	@Test
	public void reg() {
		try {
			User user = new User();
			user.setUsername("a");
			user.setPassword("123");
			userService.reg(user);
			System.out.println("OK");
		} catch (ServiceException e) {
			// TODO 自动生成的 catch 块
			System.out.println(e.getClass().getSimpleName());
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void login() {
		User user = userService.login("123", "123");
		System.out.println(user);
	}
	
}
