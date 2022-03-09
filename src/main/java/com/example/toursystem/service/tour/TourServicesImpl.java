package com.example.toursystem.service.tour;

import com.example.toursystem.dao.tour.TourDAO;
import com.example.toursystem.dao.tour.TourDAOService;
import com.example.toursystem.entity.tour.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TourServicesImpl implements TourServices{

    private TourDAOService tourDAOService;

    @Autowired
    public TourServicesImpl(TourDAOService tourDAOService) {
        this.tourDAOService = tourDAOService;
    }

    @Override
    @Transactional
    public void updateOrCreateTour(Tour tour) {
        tourDAOService.updateOrCreateTour(tour);
    }

    @Override
    @Transactional
    public List<Tour> findAll() {
        return tourDAOService.findAll();
    }

    @Override
    @Transactional
    public List<Tour> findWithHostUsername(String username) {
        return tourDAOService.findWithHostUsername(username);
    }

    @Override
    @Transactional
    public Tour findWithId(int id) {
        return tourDAOService.findWithId(id);
    }
}
