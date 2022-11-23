package com.ssafy.train.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

//빈 등록
@Component
//Aspect 관련 클래스파일임을 알려줌
@Aspect
@Slf4j
public class LoggingAspect {

	@Before(value = "execution(* com.ssafy.train.model.*.*.*(..)) || execution(* com.ssafy.train.controller.*.*(..)) || execution(* com.ssafy.train.interceptor.*.*(..))")
	public void logging(JoinPoint jp) {

		Signature sig = jp.getSignature(); // 메소드에 대한 설명 정보
		Object[] args = jp.getArgs();

		log.debug("메서드 선언부: {}, 전달 파라미터: {}", sig, args);
	}
}
