package com.ssafy.mvc.model.service;

import java.sql.SQLException;

import com.ssafy.mvc.dto.User;

public interface UserService {

	User find(User user) throws SQLException;
	
}
