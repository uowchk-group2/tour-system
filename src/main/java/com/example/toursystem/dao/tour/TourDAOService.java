package com.example.toursystem.dao.tour;

import com.example.toursystem.entity.tour.Tour;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class TourDAOService implements TourDAO{

    private EntityManager entityManager;

    public TourDAOService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void updateOrCreateTour(Tour tour) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(tour);
    }

    @Override
    public List<Tour> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("FROM Tour", Tour.class);
        List<Tour> tours = theQuery.getResultList();
        return tours;
    }

    @Override
    public List<Tour> findWithHostUsername(String username) {
        Session currentSession = entityManager.unwrap(Session.class);
        String hql = "FROM Tour t WHERE t.hostUsername = '"+username+"'";
        Query query = currentSession.createQuery(hql,Tour.class);
        List<Tour> tours = query.getResultList();

        return tours;
    }

    @Override
    public Tour findWithId(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Tour tour = currentSession.get(Tour.class, id);

        return tour ;
    }

    @Override
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("delete from Tour where id=:tourId");
        theQuery.setParameter("tourId",id);
        theQuery.executeUpdate();

    }
}
