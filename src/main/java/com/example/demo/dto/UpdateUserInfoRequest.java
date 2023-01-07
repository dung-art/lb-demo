package com.example.demo.dto;

import com.example.demo.constant.GenderEnum;
import com.example.demo.constant.UserStatusEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserInfoRequest {
	private String userName;
	private Boolean isDisable;
	private String birthDate;
	private GenderEnum gender;
	private String phoneNumber;
	private String emailAddress;
	private UserStatusEnum status;
	private String currentAddress;
	private String description;
}
