package com.ssafy.mvctest.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.mvctest.dto.Car;
import com.ssafy.mvctest.model.service.CarService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/car")
public class CarController {

	@Autowired
	CarService carService;

	@GetMapping(value = "/list")
	public String selectAll(Model model) throws SQLException {
		List<Car> list = carService.selectAll();
		model.addAttribute("list", list);
		return "list";
	}

	@GetMapping(value = "/goRegist")
	public String goRegist() throws SQLException {
		return "regist";
	}

	@GetMapping(value = "/regist")
	public String regist(@ModelAttribute Car car) throws SQLException, Exception {
		log.debug("{}",car);
		int result = carService.regist(car);
		if (result == 1)
			return "redirect:list";
		throw new Exception();
	}
}
