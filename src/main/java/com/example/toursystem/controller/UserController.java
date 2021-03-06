package com.example.toursystem.controller;

import com.example.toursystem.entity.User;
import com.example.toursystem.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserServices userServices;

    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("profile")
    public String profile(Model model, HttpServletRequest request) {
        String success = request.getParameter("success");
        if (success != null){
            model.addAttribute("success",success);
        }

        String username = request.getUserPrincipal().getName();
        User user = userServices.findByUsername(username);
        if (user.getUsername() != null) {
            model.addAttribute("user", user);
        }
        return "user/profile";
    }

    @PostMapping("profile")
    public RedirectView profileSubmit(@ModelAttribute User user, HttpServletRequest request) {
        System.out.println(request.getRequestURL());
        try {
            User userFromQuery = userServices.findByID(user.getId());
            userFromQuery.setEmail(user.getEmail());
            userFromQuery.setFullName(user.getFullName());
            userFromQuery.setNationality(user.getNationality());

            userServices.save(userFromQuery);
        }catch (Exception e){
            System.out.println("Error: "+ e.getMessage());
            return new RedirectView(request.getRequestURL() + "?success=false");
        }

        return new RedirectView(request.getRequestURL() + "?success=true");
    }

    @GetMapping("chat")
    public String chat(Model model,HttpServletRequest request){
        String username = request.getUserPrincipal().getName();
        model.addAttribute("username",username);
        return "user/chat";
    }




}
