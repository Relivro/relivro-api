package com.api.relivro.controller;

import com.api.relivro.dto.UserRegistrationData;
import com.api.relivro.model.UserModel;
import com.api.relivro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public void register(@RequestBody UserRegistrationData data) {
        userRepository.save(new UserModel(data));
    }
}
