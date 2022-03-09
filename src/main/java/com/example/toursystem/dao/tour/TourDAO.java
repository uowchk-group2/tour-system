package com.example.toursystem.dao.tour;

import com.example.toursystem.entity.tour.Tour;

import java.util.List;

public interface TourDAO {

    public void updateOrCreateTour(Tour tour);

    public List<Tour> findAll();

    public List<Tour> findWithHostUsername(String username);

    public Tour findWithId(int id);

}
