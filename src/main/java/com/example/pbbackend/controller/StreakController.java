package com.example.pbbackend.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StreakController {
    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }
}

