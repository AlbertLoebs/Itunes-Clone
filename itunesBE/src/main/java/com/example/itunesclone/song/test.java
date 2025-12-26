package com.example.itunesclone.song;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
    @GetMapping("/api/hello")
        public String hello() {
            return "Hello";
        }
    }
