package com.example.toursystem.controller;

import com.example.toursystem.entity.ApproveStatus;
import com.example.toursystem.entity.User;
import com.example.toursystem.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class HomeController {
    @Autowired
    private UserServices userServices;

    @GetMapping("/")
    public String homepage(Model model, HttpServletRequest request, Principal principal){
        //Check error
        if (request.getParameter("error") != null){
            model.addAttribute("loginError",true);
        }

        //Check role
        if (request.isUserInRole("ROLE_STAFF")){
            return "/staff/welcome";
        }
        if (request.isUserInRole("ROLE_HOST")){
            String username = principal.getName();
            User user = userServices.findByUsername(username);
            if (user.getHostApproveStatus() == ApproveStatus.APPROVED){
                return "/host/welcome";
            }
            model.addAttribute("user",user);
            return "/signup/signupResult";
        }
        if (request.isUserInRole("ROLE_TOURIST")){
            return "/tourist/welcome";
        }
        return "home";
    }

    @GetMapping("hostSignup")
    public String hostSignup(Model model){
        return "UserController/hostSignup";
    }
    @GetMapping("touristSignup")
    public String touristSignup(Model model){
        return "UserController/touristSignup";
    }

    @GetMapping("/tour/{tourId}")
    public String tourDetailPage(@PathVariable String tourId, Model model){
        model.addAttribute("tourId", tourId);
        return "tourDetail";
    }

    @GetMapping("/profile/{username}")
    public String profilePage(@PathVariable String username, Model model){
        User user = userServices.findByUsername(username);
        if (user.getUsername() != null) {
            model.addAttribute("user", user);
        }
        return "profile";
    }

}
