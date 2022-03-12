package com.example.toursystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/host")
public class HostController {

    private Object tourService;

    @GetMapping("")
    public String demopage(Model model, HttpServletRequest request){
        String signup = request.getParameter("signup");
        if (signup != null){
            model.addAttribute("signUpSuccess",true);
        }

        return "host/welcome";
    }
    @GetMapping("create")
    public String create(Model model, HttpServletRequest request){
        String username = request.getUserPrincipal().getName();
        model.addAttribute("username", username);
        return "host/create";
    }
    @GetMapping("manage")
    public String manage(Model model, HttpServletRequest request){
        String username = request.getUserPrincipal().getName();
        model.addAttribute("username", username);

        String newCreate = request.getParameter("newCreate");
        if ( newCreate != null){
            model.addAttribute("newCreate",true);
        }
        return "host/manage";
    }
    @GetMapping("tourDetailEdit")
    public String tourDetailEdit(Model model){

        return "host/tourDetailEdit";
    }
    @GetMapping("review")
    public String review(Model model){

        return "host/review";
    }
    @GetMapping("hostReport")
    public String hostReport(Model model){

        return "host/hostReport";
    }
    @GetMapping("receive")
    public String receive(Model model){

        return "host/receive";
    }
    @GetMapping("stats")
    public String stats(Model model){

        return "host/stats";
    }

    @GetMapping("/deletetour/{id}")
    public String deletetour(@PathVariable (value="id") long id) {

        this.tourService,deletetById(id);
        return "redirect:/";
    }
}
