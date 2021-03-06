package com.example.toursystem.service;

import com.example.toursystem.dao.UserDAOService;
import com.example.toursystem.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServicesImpl implements UserServices{

    private UserDAOService userDAOService;

    @Autowired
    public UserServicesImpl(UserDAOService userDAOService) {
        this.userDAOService = userDAOService;
    }


    @Override
    @Transactional
    public List<User> findAll() {
        return userDAOService.findAll();
    }

    @Override
    @Transactional
    public User findByID(int ID) {
        return userDAOService.findByID(ID);
    }

    @Override
    @Transactional
    public User findByUsername(String username) {
        return userDAOService.findByUsername(username);
    }

    @Override
    @Transactional
    public void save(User user) {
        userDAOService.newUser(user);
    }
}
