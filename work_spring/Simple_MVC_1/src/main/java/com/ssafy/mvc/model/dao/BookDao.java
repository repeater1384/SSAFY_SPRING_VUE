package com.ssafy.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.mvc.dto.Book;

public interface BookDao {
	/**
	 * 책 목록을 반환해주는 메소드입니다용
	 * @return 책 목록
	 * @throws SQLException
	 */
	List<Book> selectAll() throws SQLException;
	
}
