package com.example.itunesclone.auth.service;

import com.example.itunesclone.auth.dto.AuthResponse;
import com.example.itunesclone.auth.dto.LoginRequest;
import com.example.itunesclone.auth.dto.RegisterRequest;
import com.example.itunesclone.user.entity.User;
import com.example.itunesclone.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.itunesclone.config.SecurityBeans;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthResponse register (RegisterRequest registerRequest) {
        String email = registerRequest.email().toLowerCase().trim();

        if (userRepository.existsByEmail(email)) {
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

    public AuthResponse login (LoginRequest loginRequest){

        String email = loginRequest.email().toLowerCase().trim();

        Optional<User> user = userRepository.findByEmail(email);

        if(user.isEmpty()){
            throw new IllegalArgumentException("The email or password does not exist");
        }

        User newUser = user.get();

        if (!passwordEncoder.matches(loginRequest.password(), newUser.getPasswordHash())){
            throw new IllegalArgumentException("Invalid email or password");
        }

        return new AuthResponse(
                newUser.getId(),
                newUser.getEmail(),
                newUser.getFirstName(),
                newUser.getLastName()
        );
    }

}
