package com.example.ecommerce.features.user.service;

import com.example.ecommerce.features.user.dto.request.LoginRequest;
import com.example.ecommerce.features.user.dto.request.SignupRequest;
import com.example.ecommerce.features.user.model.User;

public interface UserService {
    User signupUser(SignupRequest signupRequest);
    String loginUser(LoginRequest loginRequest);
}
