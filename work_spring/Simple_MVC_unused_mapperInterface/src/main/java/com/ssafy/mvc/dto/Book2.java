package com.ssafy.mvc.dto;

import lombok.Data;
import lombok.NonNull;

//@Getter
//@Setter
//@ToString
//@Slf4j	//logger 변수 추가
//@AllArgsConstructor
//@NoArgsConstructor
//@EqualsAndHashCode

//Getter, Setter, ToString, 
//EqualsAndHashCode, RequiredArgsConstructor
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
