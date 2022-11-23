package com.ssafy.train.model.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.train.dto.User;

@Mapper
public interface UserMapper {

	User doLogin(User user) throws SQLException;

	int doRegist(User user) throws SQLException;
}
