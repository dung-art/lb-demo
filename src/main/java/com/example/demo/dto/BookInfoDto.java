package com.example.demo.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookInfoDto {
	private String id;
	private Boolean isDisable;
	private String createUser;
	private LocalDateTime createDate;
	private LocalDateTime modifyDate;
	private String modifiedUser;
	private String modifyAction;
	private String bookName;
	private String category;
	private String auth;
	private Float price;
	private String bookImage;
	private String publisher;
	private String description;
}
