package com.example.toursystem.dao;

import com.example.toursystem.model.User;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOService implements UserDAO{

    private EntityManager entityManager;

    public UserDAOService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User findByID(int ID) {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        Session currentSession = entityManager.unwrap(Session.class);
        User user = currentSession.get(User.class, username);
        return user;
    }

    @Override
    public void newUser(User user) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(user);
    }

}
