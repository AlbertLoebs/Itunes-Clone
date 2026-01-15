package com.example.itunesclone.auth.service;

import com.example.itunesclone.auth.dto.AuthResponse;
import com.example.itunesclone.auth.dto.LoginRequest;
import com.example.itunesclone.auth.dto.RegisterRequest;
import com.example.itunesclone.user.entity.User;
import com.example.itunesclone.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.itunesclone.config.SecurityBeans;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthResponse register (RegisterRequest registerRequest){
        String email = registerRequest.email().toLowerCase().trim();

        if (userRepository.existsByEmail(email)){
            throw new IllegalArgumentException("This email is already in use.");
        }

        User user = new User();
        user.setFirstName(registerRequest.firstName());
        user.setLastName(registerRequest.lastName());
        user.setEmail(email);
        user.setPasswordHash(passwordEncoder.encode(registerRequest.password()));

        User saved = userRepository.save(user);

        return new AuthResponse(saved.getId(), saved.getEmail(), saved.getFirstName(), saved.getLastName());
    }

    // to do
    //public AuthResponse login (LoginRequest loginRequest){}

}
