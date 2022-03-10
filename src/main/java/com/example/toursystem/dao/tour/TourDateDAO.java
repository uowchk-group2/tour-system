package com.example.toursystem.dao.tour;

import com.example.toursystem.entity.tour.TourDate;

import java.util.List;

public interface TourDateDAO {

    public void createTourDate(TourDate tourDate);

    public List<TourDate> findWithTourId(int tourId);

    public TourDate findWithId(int Id);

    public void removeWithDateId(int dateId);

}
