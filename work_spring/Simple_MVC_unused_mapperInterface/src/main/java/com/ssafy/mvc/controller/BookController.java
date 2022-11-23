package com.ssafy.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.mvc.dto.Book;
import com.ssafy.mvc.model.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/book")
@Slf4j
public class BookController {

	// BookService 객체 주입
	@Autowired
	BookService bookService;

//	@RequestMapping(value = "/list")
//	public ModelAndView showBookList( ModelAndView mv ) throws SQLException {
//		System.out.println("showBookList() 메소드 호출");
//		//1. 전체 목록 조회 데이터 받아오기
//		List<Book> list = bookService.selectAll();
//
//		System.out.println(list);
//		
//		//Model로 처리한 결과를 담기
//		mv.addObject("list", list);
//		
//		//View 정보 담기
//		mv.setViewName("bookList");
//		
//		//2. view 반환
//		return mv;
//	}

//	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@GetMapping("/list")
	public String showBookList(Model model
//			, 
//			@RequestParam("a") int a, 
//			@RequestParam("b") int b,
//			@ModelAttribute("c") int c
	) throws SQLException {
		log.debug("showBookList() 메소드 호출");

		// redirect로 넘겨준 쿼리스트링 데이터 추출
//		System.out.println("a:"+a);
//		System.out.println("b:"+b);
//		System.out.println("c:"+c);

		// 1. 전체 목록 조회 데이터 받아오기
		List<Book> list = bookService.selectAll();

		// Model로 처리한 결과를 담기
		model.addAttribute("list", list);

		log.debug(bookService.getClass().getName());

		// 2. view 반환
		return "bookList";
	}

	@RequestMapping(value = "/list2")
	public String showBookList2(RedirectAttributes re) throws SQLException {
		// 리다이렉트 시 정보 넘길 때
		re.addAttribute("a", 10);
		re.addAttribute("b", 20);
		re.addFlashAttribute("c", 30);

		// 2. view 반환 - redirect
		return "redirect:list";
	}
}
