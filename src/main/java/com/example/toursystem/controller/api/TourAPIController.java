package com.example.toursystem.controller.api;

import com.example.toursystem.entity.tour.Tour;
import com.example.toursystem.entity.tour.TourDate;
import com.example.toursystem.entity.tour.TourParticipant;
import com.example.toursystem.service.tour.TourDateServices;
import com.example.toursystem.service.tour.TourParticipantServices;
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
    private TourParticipantServices tourParticipantServices;

    @Autowired
    public TourAPIController(TourServices tourServices, TourDateServices tourDateServices, TourParticipantServices tourParticipantServices) {
        this.tourServices = tourServices;
        this.tourDateServices = tourDateServices;
        this.tourParticipantServices = tourParticipantServices;
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

    @GetMapping("/tourDateDetail/{tourDateId}")
    public TourDate getTourDateDetail(@PathVariable int tourDateId){
        try {
            TourDate tourDate = tourDateServices.findWithId(tourDateId);
            return tourDate;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new TourDate();
        }
    }

    @GetMapping("tourParticipant/{tourDateId}")
    public List<TourParticipant> getTourParticipantList(@PathVariable int tourDateId){

        try {
            List<TourParticipant> participantList = tourParticipantServices.getParticipantList(tourDateId);
            return participantList;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ArrayList<>();
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


    @PostMapping("/saveParticipant")
    public String saveTourParticipant(@RequestBody TourParticipant tourParticipant){
        try {
            tourParticipantServices.createRecord(tourParticipant);
            return "success";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @GetMapping("/participant")
    public TourParticipant getParticipantDetailOfUser(@RequestBody TourParticipant tourParticipant){
        try {
            int tourId = tourParticipant.getTourId();
            int tourDateId = tourParticipant.getTourDateId();
            String username = tourParticipant.getUsername();
            TourParticipant participant = tourParticipantServices.retrieveUserRecord(tourId, tourDateId, username);
            return participant;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new TourParticipant();
        }
    }

    @GetMapping("/participants/{tourDateId}")
    public List<TourParticipant> getParticipantList(@PathVariable int tourDateId){
        try {
            List<TourParticipant> participantList = tourParticipantServices.getParticipantList(tourDateId);
            return participantList;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    @GetMapping("/userJoined/{username}")
    public List<TourParticipant> getUserJoinedList(@PathVariable String username){
        try {
            List<TourParticipant> joinedTours = tourParticipantServices.retrieveUserRecords(username);
            return joinedTours;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }

    }

    @DeleteMapping("/participant/{id}")
    public String removeParticipant(@PathVariable int id){
            tourParticipantServices.removeRecord(id);
        try {
            return "success";
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
