package com.example.demo.dto;

import java.time.LocalDateTime;

import com.example.demo.constant.AccountTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
	private String id;
	private Boolean isDisable;
	private String createUser;
	private LocalDateTime createDate;
	private LocalDateTime modifyDate;
	private String modifiedUser;
	private String modifyAction;
	private String displayName;
	private AccountTypeEnum accountType;
	private String accountName;
}
