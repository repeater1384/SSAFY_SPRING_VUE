package com.ssafy.rest.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.rest.dto.Book;
import com.ssafy.rest.model.mapper.BookMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookServiceImpl implements BookService {
	@Autowired
	BookMapper bookMapper;

	public List<Book> selectAll() throws SQLException {
		return bookMapper.selectAll();
	}

	@Override
	public int insertBook(Book book) throws SQLException {
		return bookMapper.insertBook(book);
	}

}
