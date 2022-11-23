package com.ssafy.mvc.model.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.mvc.dto.User;

@Mapper
public interface UserMapper {

	/**
	 * 책 목록 전체 조회
	 */
	User find(User user) throws SQLException;
}
