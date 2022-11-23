package com.ssafy.train.model.service;

import java.sql.SQLException;

import com.ssafy.train.dto.User;

public interface UserService {
	boolean doLogin(User user) throws SQLException;
	void doRegist(User user) throws SQLException;
}
