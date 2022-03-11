package com.example.toursystem.dao;

import com.example.toursystem.dao.ReviewDAO;
import com.example.toursystem.entity.Review;
import com.example.toursystem.entity.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ReviewDAOService implements ReviewDAO {

    private EntityManager entityManager;

    @Autowired
    public ReviewDAOService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveReview(Review review) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(review);
    }

    @Override
    public List<Review> getReviewByAuthorUsername(String authorUsername) {
        Session currentSession = entityManager.unwrap(Session.class);
        String hql = "FROM Review r WHERE r.author = '"+authorUsername+"'";
        Query query = currentSession.createQuery(hql,Review.class);
        List<Review> resultList = query.getResultList();

        return resultList;
    }

    @Override
    public List<Review> getReviewByTourId(int tourId) {
        Session currentSession = entityManager.unwrap(Session.class);
        String hql = "FROM Review r WHERE r.tourId = '"+tourId+"'";
        Query query = currentSession.createQuery(hql,Review.class);
        List<Review> resultList = query.getResultList();

        return resultList;
    }

    @Override
    public List<Review> getReviewByUserUsername(String userUsername) {
        Session currentSession = entityManager.unwrap(Session.class);
        String hql = "FROM Review r WHERE r.userUsername = '"+userUsername+"'";
        Query query = currentSession.createQuery(hql,Review.class);
        List<Review> resultList = query.getResultList();

        return resultList;
    }

    @Override
    public void removeReviewById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("delete from Review where id=:id");
        theQuery.setParameter("id",id);
        theQuery.executeUpdate();
    }
}
