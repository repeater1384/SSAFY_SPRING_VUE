package com.ssafy.mvc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

	@Before(value = "execution(* com.ssafy.mvc.controller.*.*(..)) || execution(* com.ssafy.mvc.model.*.*.*(..))")
	public void logging(JoinPoint jp) {
		Signature sig = jp.getSignature();
		Object[] args = jp.getArgs();
		log.debug("메서드 선언부 : {}, 전달 파라미터: {}", sig, args);
	}

	@Around(value = "execution(* com.ssafy.mvc.model.dao.BookDaoImpl.selectAll())")
	public Object calcTime(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();

		// 원래 메소드를 실행하는 코드
		Object obj = pjp.proceed();
		long end = System.currentTimeMillis();
		log.debug("수행시간 : {}ms", end - start);

		return obj;
	}

}
