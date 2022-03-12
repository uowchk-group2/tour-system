package com.example.toursystem.service;

import com.example.toursystem.dao.ReviewDAOService;
import com.example.toursystem.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ReviewServicesImpl implements ReviewServices{

    private ReviewDAOService reviewDAOService;

    @Autowired
    public ReviewServicesImpl(ReviewDAOService reviewDAOService) {
        this.reviewDAOService = reviewDAOService;
    }

    @Override
    @Transactional
    public void saveReview(Review review) {
        reviewDAOService.saveReview(review);
    }

    @Override
    @Transactional
    public List<Review> getReviewByAuthorUsername(String authorUsername) {
        return reviewDAOService.getReviewByAuthorUsername(authorUsername);
    }

    @Override
    @Transactional
    public List<Review> getReviewByTourId(int tourId) {
        return reviewDAOService.getReviewByTourId(tourId);
    }

    @Override
    @Transactional
    public List<Review> getReviewByUserUsername(String userUsername) {
        return reviewDAOService.getReviewByUserUsername(userUsername);
    }

    @Override
    @Transactional
    public void removeReviewById(int id) {
        reviewDAOService.removeReviewById(id);
    }
}
