package com.example.toursystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class signup {
    @GetMapping("host")
    public String hostSignup(Model model){
        return "signup/host";
    }
    @GetMapping("tourist")
    public String touristSignup(Model model){
        return "signup/tourist";
    }

}
