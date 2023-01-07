package com.example.demo.dto;

import com.example.demo.constant.BookConditionEnum;
import com.example.demo.constant.BookStatusEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateBookRequest {
	private Boolean isDisable;
	private String bookInfoId;
	private BookConditionEnum bookCondition; // tình trạng sách
	private BookStatusEnum status;
}
