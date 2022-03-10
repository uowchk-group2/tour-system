package com.example.toursystem.service.tour;

import com.example.toursystem.dao.tour.TourParticipantDAO;
import com.example.toursystem.dao.tour.TourParticipantDAOService;
import com.example.toursystem.entity.tour.TourParticipant;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TourParticipantServicesImpl implements TourParticipantServices{

    private TourParticipantDAOService tourParticipantDAOService;

    @Autowired
    public TourParticipantServicesImpl(TourParticipantDAOService tourParticipantDAOService) {
        this.tourParticipantDAOService = tourParticipantDAOService;
    }

    @Override
    public void createRecord(TourParticipant tourParticipant) {
        tourParticipantDAOService.createRecord(tourParticipant);
    }

    @Override
    public TourParticipant retrieveUserRecord(int tourId, int tourDateId, String username) {
        return tourParticipantDAOService.retrieveUserRecord(tourId, tourDateId, username);
    }

    @Override
    public List<TourParticipant> getParticipantList(int tourDateId) {
        return tourParticipantDAOService.getParticipantList(tourDateId);
    }

    @Override
    public void removeRecord(int tourParticipantId) {
        tourParticipantDAOService.removeRecord(tourParticipantId);
    }
}
