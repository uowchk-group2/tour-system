package com.example.toursystem.dao;

import com.example.toursystem.model.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
        String hql = "FROM User u WHERE u.username = '"+username+"'";
        Query query = currentSession.createQuery(hql);
        query.setMaxResults(1);
        User result = new User();

        try {
            Object result1 = query.getSingleResult();
            result = (User) result1;
        }catch (Exception e){
            System.out.println("Exceiption: "+e.getMessage());
        }

        return result;
    }

    @Override
    public void newUser(User user) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(user);
    }

}
