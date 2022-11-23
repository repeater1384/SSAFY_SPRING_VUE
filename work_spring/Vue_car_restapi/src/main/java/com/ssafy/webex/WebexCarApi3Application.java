package com.ssafy.webex;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan(basePackages = "com.ssafy.webex.model.mapper")
public class WebexCarApi3Application {

	public static void main(String[] args) {
		SpringApplication.run(WebexCarApi3Application.class, args);
	}

}
