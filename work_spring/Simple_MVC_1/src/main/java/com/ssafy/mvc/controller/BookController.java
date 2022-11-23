package com.ssafy.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
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

	@RequestMapping(value = "/list")
	public ModelAndView showBookList(ModelAndView mv, @RequestParam("a") int a, @RequestParam("b") int b,
			@ModelAttribute("c") int c) throws SQLException {
		log.info(String.format("%d %d %d", a, b, c));
		// 1. 전체목록 조회 데이터 받아오기
		List<Book> list = bookService.selectAll();

		// 모델로 처리한 결과를 담기
		mv.addObject("list", list);
		// 뷰 정보 담기
		mv.setViewName("bookList");
		log.debug(bookService.getClass().getName());

		// 2. View 반환
		return mv;
	}

	@RequestMapping(value = "/list2")
	public String showBookList2(RedirectAttributes re) throws SQLException {
		log.info("list2");
		re.addAttribute("a", 10);
		re.addAttribute("b", 20);
		re.addFlashAttribute("c", 30);
		// redirect
		return "redirect:list"; // /book/list로갑니다.
	}

	@RequestMapping(value = "/list3")
	public String showBookList3(Model model) throws SQLException {
		log.info("list3");
		List<Book> list = bookService.selectAll();
		model.addAttribute("list", list);
		return "bookList";
	}

}
