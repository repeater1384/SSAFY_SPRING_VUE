package com.ssafy.mvc.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class Book2 {
	@NonNull
	private String isbn;
	private String title;
	private String author;
	private int price;
	private String description;
	private String img;
}
