package com.example.toursystem.dao.tour;

import com.example.toursystem.entity.tour.TourParticipant;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class TourParticipantDAOService implements TourParticipantDAO{

    private EntityManager entityManager;

    @Autowired
    public TourParticipantDAOService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void createRecord(TourParticipant tourParticipant) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(tourParticipant);
    }

    @Override
    public TourParticipant retrieveUserRecord(int tourId, int tourDateId, String username) {
        Session currentSession = entityManager.unwrap(Session.class);
        String hql = "FROM TourParticipant d WHERE d.tourId = '"+tourId+"' AND d.tourDateId = '"+tourDateId+"' AND d.username = '"+username+"'";
        Query query = currentSession.createQuery(hql, TourParticipant.class);
        query.setMaxResults(1);
        List<TourParticipant> participants = query.getResultList();

        if (participants.size() == 1){
            return participants.get(0);
        }

        return null;
    }

    @Override
    public List<TourParticipant> getParticipantList(int tourDateId) {
        Session currentSession = entityManager.unwrap(Session.class);
        String hql = "FROM TourParticipant d WHERE d.tourDateId = '"+tourDateId+"'";
        Query query = currentSession.createQuery(hql, TourParticipant.class);
        List<TourParticipant> participants = query.getResultList();

        return participants;
    }

    @Override
    public void removeRecord(int tourParticipantId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("delete from TourParticipant where id=:participantId");
        theQuery.setParameter("participantId",tourParticipantId);
        theQuery.executeUpdate();
    }
}
