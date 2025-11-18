package com.example.ecommerce.features.user.controller;

import com.example.ecommerce.features.user.dto.request.LoginRequest;
import com.example.ecommerce.features.user.dto.request.SignupRequest;
import com.example.ecommerce.features.user.dto.response.AuthResponse;
import com.example.ecommerce.features.user.model.User;
import com.example.ecommerce.features.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/auth")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody SignupRequest signupRequest) {
        User user=userService.signupUser(signupRequest);

        return ResponseEntity.ok(user);
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> signin(@RequestBody LoginRequest loginRequest) {
        String token = userService.loginUser(loginRequest);
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
