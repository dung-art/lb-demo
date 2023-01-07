package com.example.demo.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.example.demo.constant.AccountTypeEnum;
import com.example.demo.constant.common.Constants;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAccountRequest {
	private Boolean isDisable = false;
	@NotNull
	private String displayName;
	@NotNull
	private String accountName;
	@NotNull
	@Pattern(regexp = Constants.PATTERN_PASSWORD)
	private String password;
	@NotNull
	@Pattern(regexp = Constants.PATTERN_PASSWORD)
	private String confirmPassword;
	@NotNull
	private AccountTypeEnum accountType;
}
