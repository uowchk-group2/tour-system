package com.example.toursystem.dao;

import com.example.toursystem.model.User;

public interface UserDAO {

    public User findByID(int ID);

    public User findByUsername(String username);

    public void newUser(User user);
}
