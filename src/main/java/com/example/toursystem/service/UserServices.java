package com.example.toursystem.service;

import com.example.toursystem.entity.User;

import java.util.List;

public interface UserServices {

    public List<User> findAll();

    public User findByID(int ID);

    public User findByUsername(String username);

    public void save(User user);
}
