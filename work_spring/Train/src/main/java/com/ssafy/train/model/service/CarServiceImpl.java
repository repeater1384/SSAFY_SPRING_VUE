package com.ssafy.train.model.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.train.dto.Car;
import com.ssafy.train.dto.FileInfo;
import com.ssafy.train.model.mapper.CarMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CarServiceImpl implements CarService {
	@Autowired
	CarMapper carMapper;

	public List<Car> allList() throws SQLException {
		return carMapper.allList();
	}
	
	public void regist(Car car) throws SQLException {
		carMapper.regist(car);
	}
	
	@Transactional
	public void regist(Car car, MultipartFile file, String path) throws SQLException, IllegalStateException, IOException {
		String today = new SimpleDateFormat("yyMMdd").format(new Date());
		File folder = new File(path + File.separator + today);
		if (!folder.exists())
			folder.mkdirs();

		String originFile = file.getOriginalFilename(); // 원본 파일 명
		// 저장될 파일명 만들기
		String saveFile = UUID.randomUUID().toString() + originFile.substring(originFile.lastIndexOf('.'));

		// 2. 파일데이터 DB에 저장
		FileInfo fileInfo = new FileInfo();
		fileInfo.setNumber(car.getNumber());
		fileInfo.setSaveFolder(today);
		fileInfo.setSaveFile(saveFile);
		fileInfo.setOriginFile(originFile);
		// 책 정보에 파일 데이터 추가
		car.setFileInfo(fileInfo);
		
		
		log.debug("{} {} {}", path, today, folder.toString());
		
		carMapper.regist(car);
		carMapper.regist2(fileInfo);
		file.transferTo(new File(folder, saveFile));
	}
	
	public Car detail(String number) throws SQLException {
		return carMapper.detail(number);
	}

}
