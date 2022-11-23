package com.ssafy.train.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.train.dto.Car;
import com.ssafy.train.dto.FileInfo;

@Mapper
public interface CarMapper {

	List<Car> allList();
	int regist(Car car);
	int regist2(FileInfo fileInfo);
	Car detail(String number);
}
