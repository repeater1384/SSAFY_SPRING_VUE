package com.ssafy.hello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller	
public class HelloController {
	
	private static final Logger log = LoggerFactory.getLogger(HelloController.class);

	@GetMapping("/hello")
	public String hello(Model model) {
		log.info("hello() call!");
		model.addAttribute("msg","안녕하세요!");
		return "hello";
	}
}
