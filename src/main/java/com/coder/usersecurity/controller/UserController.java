package com.coder.usersecurity.controller;

import com.coder.usersecurity.model.MyUser;
import com.coder.usersecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    UserService service;

    @GetMapping
    public String homePage() {
        return "Hello Users, Just Enjoy!";
    }

    @GetMapping("/users")
    public List<MyUser> findAll() {
        return service.findAll();
    }

    @GetMapping("/user/{id}")
    public MyUser findUser(@PathVariable long id) {
        return service.findUser(id);
    }

    @PostMapping("/user")
    public MyUser addUser(@RequestBody MyUser myUser) {
        return service.addUser(myUser);
    }

}
