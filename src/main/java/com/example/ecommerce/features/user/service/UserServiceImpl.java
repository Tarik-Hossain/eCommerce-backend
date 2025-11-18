package com.example.ecommerce.features.user.service;

import com.example.ecommerce.features.user.dto.request.LoginRequest;
import com.example.ecommerce.features.user.dto.request.SignupRequest;
import com.example.ecommerce.features.user.model.User;
import com.example.ecommerce.features.user.repository.UserRepository;
import com.example.ecommerce.features.user.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;  // Inject PasswordEncoder
    }

    @Override
    public User signupUser(SignupRequest signupRequest) {
        User user = new User();
        user.setUsername(signupRequest.getUsername());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));  // Hash the password
        user.setRole(signupRequest.getRole());
        System.out.println("Entered password: ============" + passwordEncoder.encode(signupRequest.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public String loginUser(LoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new BadCredentialsException("Invalid credentials"));

        System.out.println("Entered password: ==========================================" + loginRequest.getPassword());
        System.out.println("Stored password (hashed): " + user.getPassword());
        // Compare hashed password
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Invalid credentials 1");
        }

        // Generate and return JWT token
        return jwtUtil.generateToken(user.getUsername(), user.getRole());
    }
}
