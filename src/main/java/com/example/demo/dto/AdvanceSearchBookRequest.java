package com.example.demo.dto;

import java.util.List;

import com.example.demo.constant.BookConditionEnum;
import com.example.demo.constant.BookStatusEnum;
import com.example.demo.dto.common.DateRange;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdvanceSearchBookRequest {
	private List<String> createUser;
	private DateRange createDate;
	private DateRange modifyDate;
	private List<String> modifiedUser;
	private List<BookConditionEnum> bookCondition; // tình trạng sách
	private List<BookStatusEnum> status;
}
