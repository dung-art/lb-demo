package com.example.demo.dto;

import java.util.List;

import com.example.demo.dto.common.DateRange;
import com.example.demo.dto.common.PriceRange;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdvanceSearchBookInfoRequest {
	private List<String> createUser;
	private DateRange createDate;
	private DateRange modifyDate;
	private List<String> modifiedUser;
	private String bookName;
	private List<String> categorys;
	private List<String> auths;
	private PriceRange price;
	private List<String> publisher; // nhà xuất bản
}
