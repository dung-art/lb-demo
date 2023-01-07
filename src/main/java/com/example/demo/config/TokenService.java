package com.example.demo.config;

import java.time.LocalDateTime;

import com.example.demo.constant.TokenTypeEnum;


public interface TokenService {
	void saveToken(String userId, TokenTypeEnum tokenType, String value, LocalDateTime affectDate,
			LocalDateTime expireDate);

	boolean isTokenValid(String userId, String value);

	Boolean revokeToken(String accountId);
}