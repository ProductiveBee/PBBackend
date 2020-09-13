package com.example.pbbackend.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class StreakController {
    @GetMapping("/hello")
    public RedirectView sayHello() {
        return new RedirectView("/homepage");
    }
}

