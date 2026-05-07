package com.task_manager.controller;

import com.task_manager.dto.AuthResponse;
import com.task_manager.dto.LoginRequest;
import com.task_manager.dto.SignupRequest;
import com.task_manager.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public String signup(@Valid @RequestBody SignupRequest request) {
        return authService.signup(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {

        String token = authService.login(request);

        return new AuthResponse(token);
    }
}