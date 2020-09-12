package com.example.pbbackend.controller;

import com.example.pbbackend.model.User;
import com.example.pbbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        List<User> user = userRepository.findAll();
        System.out.println(user.size());
        return user;
    }

//    @GetMapping("/getUser{account_id}")
//    public User getUser(){
//        return userRepository.findById(account_id);
//    }

}
