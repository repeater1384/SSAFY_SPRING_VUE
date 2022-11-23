package com.ssafy.train.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.train.dto.Car;
import com.ssafy.train.model.service.CarService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/car")
@Slf4j
public class CarController {

	@Autowired
	CarService carService;
	@Autowired
	ServletContext servletContext;

	@GetMapping("/list")
	public String goList(Model model) throws SQLException {
		List<Car> list = carService.allList();
		model.addAttribute("list", list);
		return "car/list";
	}

	@GetMapping("/regist")
	public String goList() throws SQLException {
		return "car/regist";
	}

	@PostMapping("/regist")
	public String doRegist(@ModelAttribute Car car, @RequestParam(required = false) MultipartFile file) throws SQLException, IllegalStateException, IOException {
		log.debug("{}", car);
		if(file.isEmpty()) {
			carService.regist(car);
		}else {
			carService.regist(car,file,servletContext.getRealPath("/upload"));
		}
		return "redirect:list";
	}

	@GetMapping("/detail")
	public String goDetail(@RequestParam String number, Model model) throws SQLException {
		model.addAttribute("car", carService.detail(number));
		return "car/detail";
	}
}
