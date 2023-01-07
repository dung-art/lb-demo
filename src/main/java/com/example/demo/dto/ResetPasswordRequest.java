package com.example.demo.dto;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.example.demo.constant.common.Constants;
import com.example.demo.validator.FieldMatch;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@FieldMatch(first = "newPassword", second = "confirmNewPassword")
public class ResetPasswordRequest {
  @NotNull
  private String accountId;
  
  @NotNull
  @Pattern(regexp = Constants.PATTERN_PASSWORD)
  private String newPassword;
  
  @NotNull
  @Pattern(regexp = Constants.PATTERN_PASSWORD)
  private String confirmNewPassword;
}