package com.example.toursystem.controller;

import com.example.toursystem.service.tour.TourServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/host")
public class HostController {

    private TourServices tourServices;

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
    public String review(Model model,HttpServletRequest request){
        String success = request.getParameter("success");
        if (success != null){
            System.out.println(success);
            if (success.length() == 4) {
                model.addAttribute("success", true);
            }else{
                model.addAttribute("success",false);
            }
        }else{
            model.addAttribute("success",null);
        }

        model.addAttribute("username",request.getUserPrincipal().getName());

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
    public String deletetour(@PathVariable int id) {

        this.tourServices.deleteById(id);
        return "redirect:/";
    }
}
