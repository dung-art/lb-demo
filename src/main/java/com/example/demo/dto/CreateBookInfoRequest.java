package com.example.demo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookInfoRequest {
	private Boolean isDisable = false;
	@NotEmpty
	@NotNull
	private String bookName;
	@NotEmpty
	@NotNull
	private String category;
	@NotEmpty
	@NotNull
	private String auth;
	@NotEmpty
	@NotNull
	private Float price;
	private String bookImage;
	@NotEmpty
	@NotNull
	private String publisher;
	private String description;
}
