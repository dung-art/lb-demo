package com.example.demo.dto;

import com.example.demo.constant.GenderEnum;
import com.example.demo.constant.UserStatusEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {
	private Boolean isDisable = false;
	private String userCode;
	private String userName;
	private String birthDate;
	private GenderEnum gender;// khoong theer sua
	private String phoneNumber;
	private String emailAddress;
	private UserStatusEnum status;
	private String currentAddress;
	private String description;
}
