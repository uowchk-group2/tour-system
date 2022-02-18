package com.example.toursystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/host")
public class host {

    @GetMapping("")
    public String demopage(Model model){
        return "./host/welcome";
    }
    @GetMapping("signup")
    public String signup(Model model){
        return "./host/signup";
    }
    @GetMapping("create")
    public String create(Model model){
        return "./host/create";
    }
    @GetMapping("manage")
    public String manage(Model model){
        return "./host/manage";
    }
    @GetMapping("review")
    public String review(Model model){
        return "./host/review";
    }
    @GetMapping("hostChat")
    public String hostChat(Model model){
        return "./host/hostChat";
    }
    @GetMapping("hostReport")
    public String hostReport(Model model){
        return "./host/hostReport";
    }
    @GetMapping("receive")
    public String receive(Model model){
        return "./host/receive";
    }


}
