package com.example.ecommerce.features.login.dto.res;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignupResponse {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String fullName;
}