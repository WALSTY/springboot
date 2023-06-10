package com.example.demo.service.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.IUserService;
import com.example.demo.service.ex.InsertException;
import com.example.demo.service.ex.PasswordNotMatchException;
import com.example.demo.service.ex.UserNotFoundException;
import com.example.demo.service.ex.UsernameDuplicateException;


@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void reg(User user) {
		
		String username = user.getUsername();
		
		User result = userMapper.findByUsername(username);
		
		if(result != null) {
			throw new UsernameDuplicateException("zanyong");
		}
		
		String oldPassword = user.getPassword();
		String salt = UUID.randomUUID().toString().toUpperCase();
		user.setSalt(salt);
		
		String md5Password = getMD5Password(oldPassword, salt);
		user.setPassword(md5Password);
		
		user.setNickname(user.getNickname());
		user.setEmail(user.getEmail());
		user.setIsDelete(0);
		user.setCreatedUser(user.getUsername());
		user.setModifiedUser(user.getUsername());
		Date date = new Date();
		user.setCreatedTime(date);
		user.setModifiedTime(date);
		
		Integer rows = userMapper.insert(user);
		
		if(rows != 1) {
			throw new InsertException("yichang");
		}
		
	}
	
	private String getMD5Password(String password, String salt) {
		
		for(int i = 0; i < 3; i++) {
			password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
		}
		
		return password;
		
	}

	@Override
	public User login(String username, String password) {
		
		User result = userMapper.findByUsername(username);
		
		if(result == null) {
			throw new UserNotFoundException("bucunzai");
		}
		
		String oldPassword = result.getPassword();
		String salt = result.getSalt();
		String newMd5Password = getMD5Password(password, salt);
		if(newMd5Password.equals(oldPassword)) {
			throw new PasswordNotMatchException("mimacuowu");
		}
		
		if(result.getIsDelete() == 1) {
			throw new UserNotFoundException("shujubucunzai");
		}
		
		User user = new User();
		user.setUid(result.getUid());
		user.setUsername(result.getUsername());
		user.setNickname(result.getNickname());
		
		return user;
	}

}
