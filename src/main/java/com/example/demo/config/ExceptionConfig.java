package com.example.demo.config;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.constant.common.ErrorEnum;
import com.example.demo.dto.common.ErrorResponse;
import com.example.demo.exception.LBRException;


@ControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(LBRException.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
    protected ErrorResponse handleBlException(LBRException ex) {
        ErrorEnum err = ex.getError();
        String code = err.getCode();
        String msg = getMessage(err.getMessageId());
        return new ErrorResponse(code, msg);
    }


    @ExceptionHandler(Throwable.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
    protected ErrorResponse handleOtherThrowable(Throwable ex) {
        return new ErrorResponse(ex.getClass().getCanonicalName(), ex.getMessage());
    }

    private String getMessage(String messageId) {
        // TODO: Get message from resource file
        return "MessageId: " + messageId;
    }
}