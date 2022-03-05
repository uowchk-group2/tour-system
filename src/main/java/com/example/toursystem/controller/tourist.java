package com.example.toursystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/tourist")
public class   tourist {

    @GetMapping("")
    public String demopage(Model model, HttpServletRequest request){
        String signup = request.getParameter("signup");
        if (signup != null){
            model.addAttribute("signUpSuccess",true);
        }
        return "tourist/welcome";
    }
    @GetMapping("signupResult")
    public String signupResult(Model model){
        return "tourist/signupResult";
    }
    @GetMapping("search")
    public String search(Model model){
        return "tourist/search";
    }
    @GetMapping("tourDetail")
    public String tourDetail(Model model){
        return "tourist/tourDetail";
    }
    @GetMapping("booking")
    public String booking(Model model){
        return "tourist/booking";
    }
    @GetMapping("bookingDetail")
    public String bookingDetail(Model model){
        return "tourist/bookingDetail";
    }
    @GetMapping("chat")
    public String chat(Model model){
        return "tourist/chat";
    }
    @GetMapping("payment")
    public String payment(Model model){
        return"tourist/payment";
    }
    @GetMapping("paid")
    public String paid(Model model){
        return"tourist/paid";
    }
    @GetMapping("report")
    public String report(Model model){
        return "tourist/report";
    }
    @GetMapping("review")
    public String review(Model model){
        return "tourist/review";
    }
}
