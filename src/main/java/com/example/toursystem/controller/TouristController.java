package com.example.toursystem.controller;

import com.example.toursystem.entity.tour.Tour;
import com.example.toursystem.entity.tour.TourDate;
import com.example.toursystem.entity.tour.TourParticipant;
import com.example.toursystem.service.tour.TourDateServices;
import com.example.toursystem.service.tour.TourParticipantServices;
import com.example.toursystem.service.tour.TourServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.cache.ExpressionCacheKey;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/tourist")
public class TouristController {
    private TourServices tourServices;
    private TourDateServices tourDateServices;
    private TourParticipantServices tourParticipantServices;

    @Autowired
    public TouristController(TourServices tourServices, TourDateServices tourDateServices, TourParticipantServices tourParticipantServices) {
        this.tourServices = tourServices;
        this.tourDateServices = tourDateServices;
        this.tourParticipantServices = tourParticipantServices;
    }

    @GetMapping("")
    public String demopage(Model model, HttpServletRequest request) {
        String signup = request.getParameter("signup");
        if (signup != null) {
            model.addAttribute("signUpSuccess", true);
        }
        return "tourist/welcome";
    }

    @GetMapping("signupResult")
    public String signupResult(Model model) {
        return "tourist/signupResult";
    }

    @GetMapping("search")
    public String search(Model model) {
        return "tourist/search";
    }

    @GetMapping("tourDetail/{tourId}")
    public String tourDetail(@PathVariable String tourId, Model model) {
        model.addAttribute("tourId", tourId);
        return "tourist/tourDetail";
    }

    @GetMapping("booking")
    public String booking(Model model,HttpServletRequest request) {
        model.addAttribute("username",request.getUserPrincipal().getName());

        return "tourist/booking";
    }

    @PostMapping("bookingDetail")
    public String bookingDetail(Model model) {

        return "tourist/bookingDetail";
    }

    @PostMapping("payment")
    public String payment(Model model, @ModelAttribute TourParticipant tourParticipant, HttpServletRequest request) {
        tourParticipant.setUsername(request.getUserPrincipal().getName());
        TourDate tourDate = tourDateServices.findWithId(tourParticipant.getTourDateId());
        Tour tour = tourServices.findWithId(tourParticipant.getTourId());

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = formatter.format(tourDate.getDate());

        model.addAttribute("tourParticipant", tourParticipant);

        model.addAttribute("text_dateString", formattedDate);
        model.addAttribute("text_tourName", tour.getName());
        model.addAttribute("text_quantity", tourParticipant.getQuantity());
        model.addAttribute("text_cost", tour.getFee());
        model.addAttribute("text_totalCost", (tour.getFee() * tourParticipant.getQuantity()));


        if (tourParticipant.getTourDateId() == 0) {
            model.addAttribute("error", true);
        }

        return "tourist/payment";
    }

    @PostMapping("paid")
    public String paid(Model model, @ModelAttribute TourParticipant tourParticipant) {
        try {
            Timestamp newTimestamp = new Timestamp(System.currentTimeMillis());
            tourParticipant.setJoinedTime(newTimestamp);
            tourParticipantServices.createRecord(tourParticipant);
            model.addAttribute("success", true);
        } catch (Exception e) {
            model.addAttribute("error", true);
            model.addAttribute("errorMessage", e.getMessage());

        }

        return "tourist/paid";
    }

    @GetMapping("report")
    public String report(Model model) {
        return "tourist/report";
    }

    @GetMapping("review")
    public String review(Model model) {
        return "tourist/review";
    }
}
