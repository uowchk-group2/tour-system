package com.example.toursystem.dao.tour;

import com.example.toursystem.entity.tour.Tour;
import com.example.toursystem.entity.tour.TourDate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class TourDateDAOService implements TourDateDAO{
    private EntityManager entityManager;

    @Autowired
    public TourDateDAOService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void createTourDate(TourDate tourDate) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(tourDate);
    }

    @Override
    public List<TourDate> findWithTourId(int tourId) {
        Session currentSession = entityManager.unwrap(Session.class);
        String hql = "FROM TourDate d WHERE d.tourId = '"+tourId+"'";
        Query query = currentSession.createQuery(hql,TourDate.class);
        List<TourDate> tourDates = query.getResultList();
        return tourDates;
    }

    @Override
    public void removeWithDateId(int dateId) {
        Session currentSession = entityManager.unwrap(Session.class);
        org.hibernate.query.Query theQuery = currentSession.createQuery("delete from TourDate where id=:id");
        theQuery.setParameter("id",dateId);
        theQuery.executeUpdate();
    }
}
