package com.example.toursystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tourist")
public class tourist {

    @GetMapping("")
    public String demopage(Model model){
        return "./tourist/welcome";
    }
    @GetMapping("signup")
    public String signup(Model model){
        return "./tourist/signup";
    }
    @GetMapping("apply")
    public String apply(Model model){
        return "./tourist/apply";
    }
    @GetMapping("booking")
    public String booking(Model model){
        return "./tourist/booking";
    }
    @GetMapping("chat")
    public String chat(Model model){
        return "./tourist/chat";
    }
    @GetMapping("payment")
    public String payment(Model model){
        return"./tourist/payment";
    }
    @GetMapping("report")
    public String report(Model model){
        return "./tourist/report";
    }
    @GetMapping("review")
    public String review(Model model){
        return "./tourist/review";
    }
}
