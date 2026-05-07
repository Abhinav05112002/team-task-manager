package com.task_manager.service;

import com.task_manager.dto.LoginRequest;
import com.task_manager.dto.SignupRequest;

public interface AuthService {

    String signup(SignupRequest request);

    String login(LoginRequest request);
}
