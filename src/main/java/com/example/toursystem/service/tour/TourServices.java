package com.example.toursystem.service.tour;

import com.example.toursystem.entity.tour.Tour;

import java.util.List;

public interface TourServices {
    public void updateOrCreateTour(Tour tour);

    public List<Tour> findAll();

    public List<Tour> findWithHostUsername(String username);

    public Tour findWithId(int id);

    public void deleteById(int id);
}
