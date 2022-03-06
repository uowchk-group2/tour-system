package com.example.toursystem.controller;

import com.example.toursystem.model.ApproveStatus;
import com.example.toursystem.model.User;
import com.example.toursystem.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
@RequestMapping("/signup")
public class signup {
    private UserServices userServices;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public signup(UserServices userServices, PasswordEncoder passwordEncoder) {
        this.userServices = userServices;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("host")
    public String hostSignup(Model model, HttpServletRequest request) {
        String error = request.getParameter("error");
        if (error != null) {
            model.addAttribute("error", true);
        }

        model.addAttribute("user", new User());
        return "signup/host";
    }

    @GetMapping("tourist")
    public String touristSignup(Model model, HttpServletRequest request) {
        String error = request.getParameter("error");
        if (error != null) {
            model.addAttribute("error", true);
        }
        model.addAttribute("user", new User());
        return "signup/tourist";
    }

    @PostMapping("host")
    public RedirectView hostSubmit(@ModelAttribute User user, HttpServletRequest request) {
        user.setId(0);
        String password = user.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);
        user.setRole("ROLE_HOST");
        user.setHostApproveStatus(ApproveStatus.WAITFORREVIEW);
        userServices.save(user);

        //Auto-login
        try {
            request.login(user.getUsername(), password);
        } catch (ServletException e) {
            System.out.println("Error: " + e.getMessage());
            return new RedirectView("/signup/host?error=true");
        }

        return new RedirectView("/");
    }

    @PostMapping("tourist")
    public RedirectView touristSubmit(@ModelAttribute User user, HttpServletRequest request) {
        user.setId(0);
        String password = user.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);
        user.setRole("ROLE_TOURIST");
        userServices.save(user);

        //Auto-login
        try {
            request.login(user.getUsername(), password);
        } catch (ServletException e) {
            System.out.println("Error: " + e.getMessage());
            return new RedirectView("/signup/tourist?error=true");
        }

        return new RedirectView("/tourist?signup=true");
    }

    @GetMapping("result")
    public String signupResult(Model model, HttpServletRequest request, Principal principal) {

        //Get detail of user
        String username = request.getUserPrincipal().getName();
        User user = new User();
        try {
            user = userServices.findByUsername(username);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return "home";
        }
        model.addAttribute("user", user);
        return "signup/signupResult";
    }

    @PostMapping("result")
    public RedirectView signupResultSubmit(@ModelAttribute User user, Model model, HttpServletRequest request) {
        if (request.getParameter("error") != null) {
            model.addAttribute("loginError", true);
        }
        User userFromQuery = new User();
        try {
            userFromQuery = userServices.findByUsername(user.getUsername());
            userFromQuery.setDocId(user.getDocId());
            userFromQuery.setDocHome(user.getDocHome());
            userFromQuery.setDocBank(user.getDocBank());
            userFromQuery.setHostApproveStatus(ApproveStatus.RESUBMITTED);
            userServices.save(userFromQuery);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            model.addAttribute("loginError", true);
            return new RedirectView("/signup/result?error=true");
        }

        model.addAttribute("user", userFromQuery);
        return new RedirectView("/signup/result");


    }

}
