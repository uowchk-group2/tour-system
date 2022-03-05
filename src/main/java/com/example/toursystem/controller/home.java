package com.example.toursystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class home {

    @GetMapping("/")
    public String homepage(Model model, HttpServletRequest request){
//        System.out.println("Staff: "+request.isUserInRole("ROLE_STAFF"));
//        System.out.println("Tourist: "+request.isUserInRole("ROLE_TOURIST"));
//        System.out.println("Staff: "+request.isUserInRole("ROLE_HOST"));
//        System.out.println("Test: "+);
        String error = request.getParameter("error");
        System.out.println("Error: "+(error != null));
        if (error != null){
            model.addAttribute("loginError",true);
        }
        if (request.isUserInRole("ROLE_STAFF")){
            return "/staff/welcome";
        }
        if (request.isUserInRole("ROLE_HOST")){
            return "/host/welcome";
        }
        if (request.isUserInRole("ROLE_TOURIST")){
            return "/tourist/welcome";
        }
        return "home";
    }

    @GetMapping("hostSignup")
    public String hostSignup(Model model){
        return "user/hostSignup";
    }
    @GetMapping("touristSignup")
    public String touristSignup(Model model){
        return "user/touristSignup";
    }

}
