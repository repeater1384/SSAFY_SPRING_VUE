package com.ssafy.train.model.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.train.dto.Car;

public interface CarService {
	List<Car> allList() throws SQLException;

	void regist(Car car) throws SQLException;

	void regist(Car car, MultipartFile file, String path) throws SQLException, IllegalStateException, IOException;

	Car detail(String number) throws SQLException;
}
