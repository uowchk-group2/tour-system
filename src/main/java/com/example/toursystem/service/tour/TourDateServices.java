package com.example.toursystem.service.tour;

import com.example.toursystem.entity.tour.TourDate;

import java.util.List;

public interface TourDateServices {

    public void createTourDate(TourDate tourDate);

    public List<TourDate> findWithTourId(int tourId);

    public void removeWithDateId(int dateId);

}
