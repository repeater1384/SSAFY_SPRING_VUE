package com.ssafy.train.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import lombok.extern.slf4j.Slf4j;

public class SessionConfirmInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws IOException {

		// 유저정보가 없으면 로그인 페이지로 보내자
		if (request.getSession().getAttribute("user") == null) {
			response.sendRedirect(request.getContextPath());
			// 컨트롤러로 요청이 가지 않도록 막기.
			return false;
		}

		// 유저정보가 있으면
		// 요청을 컨트롤러로 정상적으로 보냄
		return true;
	}
}
