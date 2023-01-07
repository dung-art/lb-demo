package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {
	private Boolean isDisable;
	private String bookInfoId;
	private String bookCode;
	private String status;
}
