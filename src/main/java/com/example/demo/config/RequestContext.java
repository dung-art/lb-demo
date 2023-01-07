package com.example.demo.config;

import java.util.Date;

import lombok.Data;

@Data
public class RequestContext {
	private String clientMessageId;
	private Date clientTime;
	private long receivedTime;
}