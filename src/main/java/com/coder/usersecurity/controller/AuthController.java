package com.coder.usersecurity.controller;

import com.coder.usersecurity.model.User;
import com.coder.usersecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String register(@RequestBody User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);

        return "User Registered Successfully";
    }

    @GetMapping("/admin/dashboard")
    public String admin() {
        return "Welcome Admin";
    }

    @GetMapping("/user/dashboard")
    public String user() {
        return "Welcome User";
    }
}