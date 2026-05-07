package com.task_manager.service.impl;

import com.task_manager.dto.LoginRequest;
import com.task_manager.dto.SignupRequest;
import com.task_manager.entity.User;
import com.task_manager.enums.Role;
import com.task_manager.repository.UserRepository;
import com.task_manager.security.JwtService;
import com.task_manager.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public String signup(SignupRequest request) {

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.MEMBER)
                .build();

        userRepository.save(user);

        return "User registered successfully";
    }

    @Override
    public String login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return jwtService.generateToken(user.getEmail());
    }
}
