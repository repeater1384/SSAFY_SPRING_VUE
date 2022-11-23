package com.ssafy.mvc.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.mvc.dto.User;
import com.ssafy.mvc.model.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/user")
@Slf4j
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping(value = "/login")
	public String goLogin() {
		return "user/login";
	}

	@PostMapping(value = "/login")
	public String doLogin(@ModelAttribute User user, Model model, HttpSession session) throws SQLException {
		log.debug("유저가 입력한 로그인 정보 : {}", user);
		log.debug("현재 세션 정보: {}", session.getAttribute("userInfo"));
		User userFromDB = userService.find(user);
		if (userFromDB != null) {
			log.debug("로그인 성공! 세션 할당");
			session.setAttribute("userInfo", userFromDB);
		} else {
			log.debug("로그인 실패!");
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/logout")
	public String doLogin(HttpSession session) throws SQLException {
		session.removeAttribute("userInfo");
		return "redirect:/";
	}
}
