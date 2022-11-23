package com.ssafy.webex.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object Handler)
			throws Exception {
		log.debug("요청 메소드 종류 : {}",request.getMethod());
		//OPTIONS 메소드로 넘어오는 preflight 요청은 true.
		if(HttpMethod.OPTIONS.matches(request.getMethod()))return true;
		
		final String token = request.getHeader("access-token");

		// 토큰 존재여부 체크
		if (token == null) {
			log.debug("헤더에 access-token이 없음하이~");
			response.getWriter().append("not Login");
			return false;
		}
		
		// 토큰의 유효성 검사
		try {
			Jws<Claims> claims = Jwts.parser().setSigningKey("ssafy".getBytes("UTF-8")).parseClaimsJws(token);
			log.debug("토큰 존재하고 유효함 : {}", claims.toString());
			return true;
		} catch (Exception e) {
			log.debug("토큰은 존재함 BUT 유효하지 않음 {}", e.getMessage());
			response.getWriter().append("not Login");
			return false;
		}
	}
}
