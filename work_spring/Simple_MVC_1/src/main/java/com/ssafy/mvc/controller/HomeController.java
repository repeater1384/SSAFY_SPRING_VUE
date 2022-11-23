package com.ssafy.mvc.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssafy.mvc.ApplicationContextHolder;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
//	@RequestMapping("/")
//	@GetMapping("/")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		List<ApplicationContext> list = ApplicationContextHolder.list;
		for (ApplicationContext ac : list) {
			logger.debug("어플레케이션컨텍스트 정보 : {}", ac.toString());
			String[] beanNames = ac.getBeanDefinitionNames();
			for (int i = 0; i < beanNames.length; i++) {
//				logger.debug("{}번 이름 : {}", i, beanNames[i]);
			}
		}
		return "home";
	}

}
