package com.example.itunesclone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

// copy from gpt, bypasses a login to see in the h2 console.

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Allow H2 console without authentication
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll()
                        .anyRequest().authenticated()
                )

                // H2 console uses frames, so allow same-origin frames
                .headers(headers -> headers
                        .frameOptions(frame -> frame.sameOrigin())
                )

                // Disable CSRF only for the H2 console endpoints
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**")
                )

                // Keep default login page for everything else (for now)
                .formLogin(Customizer.withDefaults());

        return http.build();
    }
}
