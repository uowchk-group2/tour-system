package com.example.toursystem.controller;

import com.example.toursystem.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

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

    @PostMapping("host")
    public RedirectView hostSubmit(@ModelAttribute User user, Model model){
        System.out.println("Profile "+user);
        System.out.println("Model");

        return new RedirectView("/host");
    }

    @PostMapping("tourist")
    public RedirectView touristSubmit(@ModelAttribute User user, Model model){

        return new RedirectView("/tourist");
    }

}
