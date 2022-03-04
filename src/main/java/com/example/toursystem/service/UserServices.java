package com.example.toursystem.service;

import com.example.toursystem.model.User;

public interface UserServices {
    public User findByID(int ID);

    public User findByUsername(String username);

    public void save(User user);
}
