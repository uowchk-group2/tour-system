package com.example.toursystem.dao;

import com.example.toursystem.model.User;

import java.util.List;

public interface UserDAO {

    public List<User> findAll();

    public User findByID(int ID);

    public User findByUsername(String username);

    public void newUser(User user);
}
