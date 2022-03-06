package com.example.toursystem.controller;

import com.example.toursystem.model.ApproveStatus;
import com.example.toursystem.model.User;
import com.example.toursystem.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/find")
    public List<User> findUser(){
        return userServices.findAll();
    }

    @GetMapping("/find/{username}")
    public User findUser(@PathVariable String username){
        User user = userServices.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found -  " + username);
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

    @PostMapping("/hostApprove/{id}")
    public String changeHostStatus(@PathVariable int id, @RequestParam String newStatus){
        try {
            User user = userServices.findByID(id);
            ApproveStatus newApproveStatus = ApproveStatus.valueOf(newStatus);
            user.setHostApproveStatus(newApproveStatus);
            userServices.save(user);
        }catch (Exception e){
            return e.getMessage();
        }
        return "success";
    }

}
