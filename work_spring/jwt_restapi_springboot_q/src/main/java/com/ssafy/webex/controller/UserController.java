package com.ssafy.webex.controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.webex.dto.User;
import com.ssafy.webex.model.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

	@Autowired
	UserService userService;

	// 로그인 요청 처리 - POST /user/login
	@PostMapping("/login")
	public ResponseEntity<?> doLogin(@RequestBody User user, HttpSession session)
			throws SQLException, UnsupportedEncodingException {
		// 유저 정보 조회
		User userInfo = userService.login(user);
		log.debug("doLogin 실행!!!");
		log.debug("{}",userInfo);
		// 로그인 성공
		if (userInfo != null) {
			final int EXPIRE_MINUTE = 10;
			final String SECRET_KEY = "ssafy";
			String token = Jwts.builder()
					// header
					.setHeaderParam("typ", "JWT").setHeaderParam("alg", "HS256")
					// payload
					.claim("id", userInfo.getId()).claim("name", userInfo.getName())
					.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * EXPIRE_MINUTE))
					.signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes("UTF-8")).compact();
			Map<String, Object> result = new HashMap<>();
			result.put("token", token);
			return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);

		}
		// 로그인 실패
		else
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
