package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePasswordRequest {
    private String username;
    private String currentPassword;
    private PasswordForm passwordForm;
}