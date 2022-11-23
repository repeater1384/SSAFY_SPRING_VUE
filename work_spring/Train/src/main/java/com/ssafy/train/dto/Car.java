package com.ssafy.train.dto;

import lombok.Data;

@Data
public class Car {
	String brand;
	String model;
	String number;
	int price;
	FileInfo fileInfo;
}
