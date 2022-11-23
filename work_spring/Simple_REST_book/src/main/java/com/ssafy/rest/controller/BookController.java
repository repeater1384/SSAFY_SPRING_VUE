package com.ssafy.rest.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.rest.dto.Book;
import com.ssafy.rest.model.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/books")
@Slf4j
@CrossOrigin("http://127.0.0.1:5500")
public class BookController {
	@Autowired
	BookService bookService;

	/**
	 * 전체 조회
	 */
	@GetMapping
	@ResponseBody
	public ResponseEntity<?> selectAll() throws SQLException {
		log.debug("selectAll() 메소드 실행");
		List<Book> list = bookService.selectAll();
		return new ResponseEntity<List<Book>>(list, HttpStatus.OK);
	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<?> insertBook(@RequestBody Book book) throws SQLException {
		log.debug("insertBook() 메소드 실행");
		log.debug("Book : {}", book);

		int cnt = bookService.insertBook(book);
		if (cnt == 1) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
