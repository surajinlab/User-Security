package com.coder.usersecurity.controller;

import com.coder.usersecurity.model.User;
import com.coder.usersecurity.repository.UserRepository;
import com.coder.usersecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    UserService service;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        System.out.println("User Registered Successfully");

        return service.registration(user);
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