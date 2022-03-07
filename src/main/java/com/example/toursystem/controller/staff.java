package com.example.toursystem.controller;

import com.example.toursystem.entity.User;
import com.example.toursystem.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class staff {
    @Autowired
    private UserServices userServices;

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
    public String hostApplication(Model model, HttpServletRequest request){
        List<User> allUser = userServices.findAll();

        model.addAttribute("users",allUser);
        return "staff/hostAppReview";
    }

}
