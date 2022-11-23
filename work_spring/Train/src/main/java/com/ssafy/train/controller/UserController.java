package com.ssafy.train.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.train.dto.User;
import com.ssafy.train.model.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/login")
	public String goLogin() {
		return "user/login";
	}

	@PostMapping("/login")
	public String doLogin(HttpSession session, @ModelAttribute User user) throws SQLException {
		boolean canLogin = userService.doLogin(user);
		if (canLogin) {
			log.debug("로그인 성공!!!!");
			session.setAttribute("user", user);
		} else {
			log.debug("로그인 실패!!!!");
		}
		return "redirect:/";
	}

	@GetMapping("/logout")
	public String goLogout(HttpSession session) {
		session.removeAttribute("user");
		log.debug("로그아웃 성공!!!!");
		return "redirect:/";
	}

	@GetMapping("/regist")
	public String goRegist() {
		return "user/regist";
	}

	@PostMapping("/regist")
	public String doRegist(@ModelAttribute User user) throws SQLException {
		userService.doRegist(user);
		return "redirect:/";
	}
}
