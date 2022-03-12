package com.example.toursystem.controller.api;

import com.example.toursystem.entity.Review;
import com.example.toursystem.service.ReviewServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
public class ReviewAPIController {

    private ReviewServices reviewServices;

    @Autowired
    public ReviewAPIController(ReviewServices reviewServices) {
        this.reviewServices = reviewServices;
    }

    @PostMapping("/review")
    public String newReview(@RequestBody Review review){
        try {
            reviewServices.saveReview(review);
            return "success";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @GetMapping("/author/{authorUsername}")
    public List<Review> getReviewByAuthorUsername(@PathVariable String authorUsername){
        try {
            return reviewServices.getReviewByAuthorUsername(authorUsername);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/tour/{tourId}")
    public List<Review> getReviewByTourId(@PathVariable int tourId){
        try {
            return reviewServices.getReviewByTourId(tourId);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/user/{userUsername}")
    public List<Review> getReviewByUserUsername(@PathVariable String userUsername){
        try {
            return reviewServices.getReviewByUserUsername(userUsername);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @DeleteMapping("/review/{id}")
    public String removeReviewById(@PathVariable int id){
        try {
            reviewServices.removeReviewById(id);
            return "success";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }
}
