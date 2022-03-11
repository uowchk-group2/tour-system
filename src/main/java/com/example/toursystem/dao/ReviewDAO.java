package com.example.toursystem.dao;

import com.example.toursystem.entity.Review;

import java.util.List;

public interface ReviewDAO {

    public void saveReview(Review review);

    public List<Review> getReviewByAuthorUsername(String authorUsername);

    public List<Review> getReviewByTourId(int tourId);

    public List<Review> getReviewByUserUsername(String userUsername);

    public void removeReviewById(int id);

}
