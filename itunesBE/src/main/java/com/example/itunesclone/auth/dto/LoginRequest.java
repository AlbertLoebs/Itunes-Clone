package com.example.itunesclone.auth.dto;

public record LoginRequest (
        String email,
        String password
) {}

