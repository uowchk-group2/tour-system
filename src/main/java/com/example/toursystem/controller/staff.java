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

}
