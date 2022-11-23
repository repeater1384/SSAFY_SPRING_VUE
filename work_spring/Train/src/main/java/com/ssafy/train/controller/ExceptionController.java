package com.ssafy.train.controller;

import java.sql.SQLException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(Exception.class)
	public String handleAllException(Exception e, Model model) {
		e.printStackTrace();
		String msg = "처리중 에러가 발생했습니다";
		if (e instanceof SQLException) {
			msg = "DB 관련 오류 발생";
		} else if (e instanceof NoHandlerFoundException) {
			msg = "404 에러";
		}
		
		model.addAttribute("msg", msg);
		return "error/error";
	}
}
