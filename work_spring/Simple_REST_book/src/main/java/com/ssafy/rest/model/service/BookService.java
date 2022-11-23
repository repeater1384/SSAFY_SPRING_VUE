package com.ssafy.rest.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.rest.dto.Book;

public interface BookService {
	List<Book> selectAll() throws SQLException;

	int insertBook(Book book) throws SQLException;
}
