package com.ssafy.mvctest.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.mvctest.dto.Car;
import com.ssafy.mvctest.model.dao.CarDao;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	CarDao carDao;

	@Override
	public List<Car> selectAll() throws SQLException {
		return carDao.selectAll();
	}

	@Override
	public int regist(Car car) throws SQLException {
		return carDao.regist(car);
	}

}
