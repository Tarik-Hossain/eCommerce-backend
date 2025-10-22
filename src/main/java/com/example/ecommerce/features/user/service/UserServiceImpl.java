package com.example.ecommerce.features.user.service;

import com.example.ecommerce.features.user.model.User;
import com.example.ecommerce.features.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String signupUser(User user) {
        // Store plain password (no encoding)
//        user.setRole("USER");  // Set default role as USER
        userRepository.save(user);
        return "User registered successfully!";
    }
}