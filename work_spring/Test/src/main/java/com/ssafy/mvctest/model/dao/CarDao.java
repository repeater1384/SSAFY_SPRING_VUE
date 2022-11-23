package com.ssafy.mvctest.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.mvctest.dto.Car;

public interface CarDao {
	List<Car> selectAll() throws SQLException;

	int regist(Car car) throws SQLException;
}
