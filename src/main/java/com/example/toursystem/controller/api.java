package com.example.toursystem.controller;

import com.example.toursystem.model.User;
import com.example.toursystem.service.UserServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class api {
    private UserServices userServices;

    public api(UserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping("/save")
    public User saveUser(@RequestBody User user){
        user.setId(0);
        userServices.save(user);
        return user;
    }

}
