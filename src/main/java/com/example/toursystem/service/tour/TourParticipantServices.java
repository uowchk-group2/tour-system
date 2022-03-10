package com.example.toursystem.service.tour;

import com.example.toursystem.entity.tour.TourParticipant;

import java.util.List;

public interface TourParticipantServices {
    public void createRecord(TourParticipant tourParticipant);

    public TourParticipant retrieveUserRecord(int tourId, int tourDateId, String username);

    public List<TourParticipant> getParticipantList(int tourDateId);

    public void removeRecord(int tourParticipantId);

}
