package com.example.toursystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/staff")
public class staff {

    @GetMapping("")
    public String demopage(Model model){
        return "staff/welcome";
    }
    @GetMapping("user")
    public String user(Model model){
        return "staff/user";
    }
    @GetMapping("tour")
    public String tour(Model model){
        return "staff/tour";
    }
    @GetMapping("report")
    public String report(Model model){
        return "staff/report";
    }
    @GetMapping("hostAppReview")
    public String hostApplication(Model model){
        return "staff/hostAppReview";
    }
    @GetMapping("chat")
    public String chat(Model model){
        return "staff/chat";
    }

}
