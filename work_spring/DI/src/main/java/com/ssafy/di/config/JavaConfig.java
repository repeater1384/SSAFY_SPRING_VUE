package com.ssafy.di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ssafy.di.model.service.HomeService;
import com.ssafy.di.model.service.HomeServiceImpl;

@Configuration
public class JavaConfig {

	@Bean
	public HomeService homeService() {
		HomeService homeService = new HomeServiceImpl();
		return homeService;
	}
}
