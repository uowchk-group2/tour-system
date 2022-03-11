package com.example.toursystem.service.tour;

import com.example.toursystem.dao.tour.TourParticipantDAO;
import com.example.toursystem.dao.tour.TourParticipantDAOService;
import com.example.toursystem.entity.tour.TourParticipant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TourParticipantServicesImpl implements TourParticipantServices{

    private TourParticipantDAOService tourParticipantDAOService;

    @Autowired
    public TourParticipantServicesImpl(TourParticipantDAOService tourParticipantDAOService) {
        this.tourParticipantDAOService = tourParticipantDAOService;
    }

    @Override
    @Transactional
    public void createRecord(TourParticipant tourParticipant) {
        tourParticipantDAOService.createRecord(tourParticipant);
    }

    @Override
    @Transactional
    public TourParticipant retrieveUserRecord(int tourId, int tourDateId, String username) {
        return tourParticipantDAOService.retrieveUserRecord(tourId, tourDateId, username);
    }

    @Override
    @Transactional
    public List<TourParticipant> retrieveUserRecords(String username) {
        return tourParticipantDAOService.retrieveUserRecords(username);
    }

    @Override
    @Transactional
    public List<TourParticipant> getParticipantList(int tourDateId) {
        return tourParticipantDAOService.getParticipantList(tourDateId);
    }

    @Override
    @Transactional
    public void removeRecord(int tourParticipantId) {
        tourParticipantDAOService.removeRecord(tourParticipantId);
    }
}
