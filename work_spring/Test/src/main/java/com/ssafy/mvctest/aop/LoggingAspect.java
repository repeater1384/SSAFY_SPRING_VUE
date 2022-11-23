package com.ssafy.mvctest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
	@Before(value = "execution(* com.ssafy.mvctest.model.*.*.*(..)) || execution(* com.ssafy.mvctest.controller.*.*(..))")
	public void logging(JoinPoint jp) {
		log.debug("메서드 선언부 : {}, 파라미터 : {}", jp.getSignature(), jp.getArgs());
	}
}
