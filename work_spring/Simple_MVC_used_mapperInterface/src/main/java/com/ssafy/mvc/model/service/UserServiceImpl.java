package com.ssafy.mvc.model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.mvc.dto.User;
import com.ssafy.mvc.model.mapper.UserMapper;

import lombok.extern.slf4j.Slf4j;

// 빈 등록
@Service
@Slf4j
public class UserServiceImpl implements UserService {

	// UserMapper 객체 주입
	@Autowired
	UserMapper userMapper;

	@Override
	public User find(User user) throws SQLException {
		log.debug("ServiceImpl의 selectAll() 실행");

		return userMapper.find(user);
	}
}
