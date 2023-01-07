package com.example.demo.exception;


import com.example.demo.constant.common.ErrorEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LBRException extends Exception{
	    private ErrorEnum error;
	    private String additionalData;
	    private static final long serialVersionUID = 8442358956304045349L;

	}
