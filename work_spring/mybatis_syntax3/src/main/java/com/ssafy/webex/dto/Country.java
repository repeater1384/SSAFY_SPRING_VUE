package com.ssafy.webex.dto;

import java.util.List;

import lombok.Data;

@Data
public class Country {
	private String code;
	private String name;
	private String continent;
	private String capital;

	// 1:1관계 인 경우
	private City capitalInfo; // 수도 정보

	// 1:N관계인 경우
	private List<CountryLanguage> languages; // 언어 정보

}
