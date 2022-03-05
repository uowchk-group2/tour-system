package com.example.toursystem.controller;

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
    public String hostSignup(Model model, HttpServletRequest request){
        String error = request.getParameter("error");
        if (error != null){
            model.addAttribute("error",true);
        }

        model.addAttribute("user", new User());
        return "signup/host";
    }
    @GetMapping("tourist")
    public String touristSignup(Model model, HttpServletRequest request){
        String error = request.getParameter("error");
        if (error != null){
            model.addAttribute("error",true);
        }
        model.addAttribute("user", new User());
        return "signup/tourist";
    }

    @PostMapping("host")
    public RedirectView hostSubmit(@ModelAttribute User user, HttpServletRequest request){
        user.setId(0);
        String password = user.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);
        user.setRole("ROLE_HOST");
        userServices.save(user);

        //Auto-login
        try {
            request.login(user.getUsername(),password);
        }catch (ServletException e){
            System.out.println("Error: "+e.getMessage());
            return new RedirectView("/signup/host?error=true");
        }

        return new RedirectView("/host?signup=true");
    }

    @PostMapping("tourist")
    public RedirectView touristSubmit(@ModelAttribute User user, HttpServletRequest request){
        user.setId(0);
        String password = user.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);
        user.setRole("ROLE_TOURIST");
        userServices.save(user);

        //Auto-login
        try {
            request.login(user.getUsername(),password);
        }catch (ServletException e){
            System.out.println("Error: "+e.getMessage());
            return new RedirectView("/signup/tourist?error=true");
        }

        return new RedirectView("/tourist?signup=true");
    }

}