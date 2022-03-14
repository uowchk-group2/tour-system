package com.example.toursystem.service.tour;

import com.example.toursystem.dao.tour.TourDateDAOService;
import com.example.toursystem.entity.tour.TourDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TourDateServicesImpl implements TourDateServices{

    private TourDateDAOService tourDateDAOService;

    @Autowired
    public TourDateServicesImpl(TourDateDAOService tourDateDAOService) {

        this.tourDateDAOService = tourDateDAOService;
    }

    @Override
    @Transactional
    public void createTourDate(TourDate tourDate) {

        tourDateDAOService.createTourDate(tourDate);
    }

    @Override
    @Transactional
    public TourDate findWithId(int Id) {
        return tourDateDAOService.findWithId(Id);
    }

    @Override
    @Transactional
    public List<TourDate> findWithTourId(int tourId) {

        return tourDateDAOService.findWithTourId(tourId);
    }

    @Override
    @Transactional
    public void removeWithDateId(int dateId) {

        tourDateDAOService.removeWithDateId(dateId);
    }
}
