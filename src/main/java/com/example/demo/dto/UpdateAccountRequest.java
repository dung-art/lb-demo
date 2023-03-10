package com.example.demo.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.demo.constant.AccountTypeEnum;
import com.example.demo.constant.common.Constants;
import com.example.demo.entity.Account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAccountRequest {
	@NotNull
	@Size(max = Account.DISPLAY_NAME_MAX_LENGTH, min = Account.DISPLAY_NAME_MIN_LENGTH)
	private String displayName;

	@NotNull
	private boolean isActive = true;

	@Min(Account.FAIL_LOGIN_COUNT_MIN)
	@Max(Account.FAIL_LOGIN_COUNT_MAX)
	private Integer failLoginCount;

	@Size(max = Constants.ID_MAX_LENGTH, min = Constants.ID_MAX_LENGTH)
	private String testSelectId;

	@Enumerated(EnumType.ORDINAL)
	private AccountTypeEnum accountType;
}