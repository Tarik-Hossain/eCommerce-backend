package com.example.ecommerce.features.user.controller;

import com.example.ecommerce.features.user.dto.request.SignupRequest;
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
    public ResponseEntity<String> signup(@RequestBody SignupRequest signupRequest) {
        // Convert the SignupRequest DTO to User entity
        User user = new User();
        user.setUsername(signupRequest.getUsername());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(signupRequest.getPassword());
        user.setRole(signupRequest.getRole());

        // Call the service to handle the signup logic
        String response = userService.signupUser(user);
        return ResponseEntity.ok(response);
    }
}
