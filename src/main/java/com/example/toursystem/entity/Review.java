package com.example.toursystem.entity;

import javax.persistence.*;

@Entity
public class Review {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "author")
    private String author;
    @Basic
    @Column(name = "tour_id")
    private Integer tourId;
    @Basic
    @Column(name = "tour_date_id")
    private Integer tourDateId;
    @Basic
    @Column(name = "tour_stars")
    private Integer tourStars;
    @Basic
    @Column(name = "tour_comment")
    private String tourComment;
    @Basic
    @Column(name = "user_username")
    private String userUsername;
    @Basic
    @Column(name = "user_stars")
    private Integer userStars;
    @Basic
    @Column(name = "user_comment")
    private String userComment;

    public Review() {
    }

    public Review(String author, Integer tourId, Integer tourDateId, Integer tourStars, String tourComment, String userUsername, Integer userStars, String userComment) {
        this.author = author;
        this.tourId = tourId;
        this.tourDateId = tourDateId;
        this.tourStars = tourStars;
        this.tourComment = tourComment;
        this.userUsername = userUsername;
        this.userStars = userStars;
        this.userComment = userComment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getTourId() {
        return tourId;
    }

    public void setTourId(Integer tourId) {
        this.tourId = tourId;
    }

    public Integer getTourDateId() {
        return tourDateId;
    }

    public void setTourDateId(Integer tourDateId) {
        this.tourDateId = tourDateId;
    }

    public Integer getTourStars() {
        return tourStars;
    }

    public void setTourStars(Integer tourStars) {
        this.tourStars = tourStars;
    }

    public String getTourComment() {
        return tourComment;
    }

    public void setTourComment(String tourComment) {
        this.tourComment = tourComment;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public Integer getUserStars() {
        return userStars;
    }

    public void setUserStars(Integer userStars) {
        this.userStars = userStars;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

}
