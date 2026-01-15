package com.example.itunesclone.auth.controller;

import com.example.itunesclone.auth.dto.AuthResponse;
import com.example.itunesclone.auth.dto.LoginRequest;
import com.example.itunesclone.auth.dto.RegisterRequest;
import com.example.itunesclone.auth.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public AuthResponse register (@RequestBody RegisterRequest registerRequest) {
        return authService.register(registerRequest);
    }

    @PostMapping("/login")
    public AuthResponse login (@RequestBody LoginRequest loginRequest) {
        return  authService.login(loginRequest);
    }

}
