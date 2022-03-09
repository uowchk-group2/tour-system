package com.example.toursystem.controller.api;

import com.example.toursystem.entity.tour.Tour;
import com.example.toursystem.service.tour.TourServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tour")
public class TourAPIController {

    private TourServices tourServices;

    @Autowired
    public TourAPIController(TourServices tourServices) {
        this.tourServices = tourServices;
    }

    @PostMapping("/save")
    public Tour saveTour(@RequestBody Tour tour){
        try {
            tourServices.updateOrCreateTour(tour);

        }catch (Exception e){
            return new Tour();
        }

        return tour;
    }

}
