package com.example.demo.mapper;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.User;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTests {
	
	@Autowired
	private UserMapper userMapper;
	 
	@Test
	public void insert() {
		User user = new User();
		user.setUsername("tom");
		user.setPassword("321");
		Integer rows = userMapper.insert(user);
		System.out.println(rows);
		
	}
	
	@Test
	public void findByUsername() {
		User user = userMapper.findByUsername("tim");
		System.out.println(user);
	}
}
