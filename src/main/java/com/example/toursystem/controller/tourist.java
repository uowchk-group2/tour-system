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

}
