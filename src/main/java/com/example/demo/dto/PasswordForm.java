package com.example.demo.dto;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.example.demo.constant.common.Constants;
import com.example.demo.validator.FieldMatch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldMatch(first = "password", second = "confirmPassword")
public class PasswordForm {
	@NotNull
	@Pattern(regexp = Constants.PATTERN_PASSWORD)
    private String password;

	@NotNull
	@Pattern(regexp = Constants.PATTERN_PASSWORD)
    private String confirmPassword;
}
