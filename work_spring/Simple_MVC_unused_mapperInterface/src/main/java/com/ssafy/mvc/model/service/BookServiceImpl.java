package com.ssafy.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import org.aspectj.lang.Signature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.mvc.dto.Book;
import com.ssafy.mvc.model.dao.BookDao;

import lombok.extern.slf4j.Slf4j;

// 빈 등록
@Service
@Slf4j
public class BookServiceImpl implements BookService {
	
	//BookDao 객체 주입
	@Autowired
	BookDao bookDao;

	@Override
	public List<Book> selectAll() throws SQLException {
		log.debug("ServiceImpl의 selectAll() 실행");
		
		return bookDao.selectAll();
	}
}
