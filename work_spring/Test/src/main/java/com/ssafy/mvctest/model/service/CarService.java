package com.ssafy.mvctest.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.mvctest.dto.Car;

public interface CarService {
	List<Car> selectAll() throws SQLException;

	int regist(Car car) throws SQLException;
}
