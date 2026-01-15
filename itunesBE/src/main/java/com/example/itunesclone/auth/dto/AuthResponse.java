package com.example.itunesclone.auth.dto;

public record AuthResponse(
        Long id,
        String email,
        String firstName,
        String lastName
){}
