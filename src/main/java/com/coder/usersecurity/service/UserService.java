package com.coder.usersecurity.service;

import com.coder.usersecurity.model.MyUser;
import com.coder.usersecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<MyUser> findAll() {
        return repository.findAll();
    }

    public MyUser addUser(MyUser myUser) {
        return repository.save(myUser);
    }

    public MyUser findUser(long id) {
        return repository.findById(id).orElse(null);
    }
}
