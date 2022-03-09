package com.example.toursystem.service.tour;

import com.example.toursystem.dao.tour.TourDateDAOService;
import com.example.toursystem.entity.tour.TourDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourDateServicesImpl implements TourDateServices{

    private TourDateDAOService tourDateDAOService;

    @Autowired
    public TourDateServicesImpl(TourDateDAOService tourDateDAOService) {
        this.tourDateDAOService = tourDateDAOService;
    }

    @Override
    public void createTourDate(TourDate tourDate) {
        tourDateDAOService.createTourDate(tourDate);
    }

    @Override
    public List<TourDate> findWithTourId(int tourId) {
        return tourDateDAOService.findWithTourId(tourId);
    }

    @Override
    public void removeWithDateId(int dateId) {
        tourDateDAOService.removeWithDateId(dateId);
    }
}
