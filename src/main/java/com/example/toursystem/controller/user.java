package com.example.toursystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class user {

    @GetMapping("passwordReset")
    public String passwordReset(Model model){
        return "user/passwordReset";
    }
    @GetMapping("profile")
    public String profile(Model model){
        return "user/profile";
    }
}
