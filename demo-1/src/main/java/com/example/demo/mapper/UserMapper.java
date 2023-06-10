package com.example.demo.mapper;

import com.example.demo.entity.User;

public interface UserMapper {


	Integer insert(User user);
	

	User findByUsername(String username);
}
