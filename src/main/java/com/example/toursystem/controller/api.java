package com.example.toursystem.controller;

import com.example.toursystem.model.User;
import com.example.toursystem.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class api {
    private UserServices userServices;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public api(UserServices userServices, PasswordEncoder passwordEncoder) {
        this.userServices = userServices;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/find/{username}")
    public User findUser(@PathVariable String username){
        User user = userServices.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found - " + username);
        }
        return user;
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody User user){
        user.setId(0);
        String password = user.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);

        userServices.save(user);
        return "Done";
    }

}
