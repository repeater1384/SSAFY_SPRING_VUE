package com.ssafy.train.model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.train.dto.User;
import com.ssafy.train.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;

	public boolean doLogin(User user) throws SQLException {
		return userMapper.doLogin(user) != null ? true : false;
	}

	public void doRegist(User user) throws SQLException {
		userMapper.doRegist(user);
	}

}
