package com.example.toursystem.controller.api;

import com.example.toursystem.entity.tour.Tour;
import com.example.toursystem.entity.tour.TourDate;
import com.example.toursystem.service.tour.TourDateServices;
import com.example.toursystem.service.tour.TourServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tour")
public class TourAPIController {

    private TourServices tourServices;
    private TourDateServices tourDateServices;

    @Autowired
    public TourAPIController(TourServices tourServices, TourDateServices tourDateServices) {
        this.tourServices = tourServices;
        this.tourDateServices = tourDateServices;
    }

    @GetMapping("/tours")
    public List<Tour> getAllTours(){
        try {
            List<Tour> tours = tourServices.findAll();
            return tours;
        }catch (Exception e) {
            return new ArrayList<Tour>();
        }
    }

    @GetMapping("/tours/{hostUsername}")
    public List<Tour> getAllTours(@PathVariable String hostUsername){
        try {
            List<Tour> tours = tourServices.findWithHostUsername(hostUsername);
            return tours;
        }catch (Exception e) {
            return new ArrayList<Tour>();
        }
    }

    @GetMapping("/tourDetail/{tourId}")
    public Tour getTourDetail(@PathVariable int tourId){
        try {
            Tour tour = tourServices.findWithId(tourId);
            return tour;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new Tour();
        }
    }


    @GetMapping("/tourDates/{tourId}")
    public List<TourDate> getTourDatesByTourId(@PathVariable int tourId){
        try {
            List<TourDate> tourDates = tourDateServices.findWithTourId(tourId);
            return tourDates;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ArrayList<TourDate>();
        }

    }

    @PostMapping("/saveTour")
    public Tour saveTour(@RequestBody Tour tour){
        try {
            tourServices.updateOrCreateTour(tour);
        }catch (Exception e){
            return new Tour();
        }
        return tour;
    }

    @PostMapping("/saveTourDates")
    public String saveTourDates(@RequestBody List<TourDate> tourDates){
        try {
            for (TourDate date : tourDates) {
                tourDateServices.createTourDate(date);
            }
            return "success";
        }catch (Exception e){
            return e.getMessage();
        }

    }


}
