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
import com.ssafy.mvc.model.service.BookServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	List<ApplicationContext>list = ApplicationContextHolder.list;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		for (ApplicationContext applicationContext : list) {
			logger.debug("{}",applicationContext);
			String[] beanNames = applicationContext.getBeanDefinitionNames();
			for(int i = 0 ;i <beanNames.length;i++)
				logger.debug("{}번 : {}",i,beanNames[i]);

		}
		return "home";
	}

}
