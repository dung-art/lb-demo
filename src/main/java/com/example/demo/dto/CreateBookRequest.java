package com.example.demo.dto;


import com.example.demo.constant.BookConditionEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookRequest {
	private Boolean isDisable = false;
	private String bookInfoId;
	private BookConditionEnum bookCondition; // tình trạng sách
}
