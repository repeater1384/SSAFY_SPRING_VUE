package com.ssafy.hello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
	
	private static final Logger log = LoggerFactory.getLogger(HelloRestController.class);
	
	@GetMapping("/resthello")
	public String hello() {
		return "Hello Rest Controller!!!";
	}
}
