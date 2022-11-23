package com.ssafy.rest.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.rest.dto.Book;

public interface BookMapper {
	List<Book> selectAll() throws SQLException;

	int insertBook(Book book) throws SQLException;
}
