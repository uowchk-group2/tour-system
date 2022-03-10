package com.example.toursystem.entity.tour;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class TourParticipant {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "tour_id")
    private int tourId;
    @Basic
    @Column(name = "tour_date_id")
    private int tourDateId;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "quantity")
    private int quantity;
    @Basic
    @Column(name = "joined_time")
    private Timestamp joinedTime;
    @Basic
    @Column(name = "card_number")
    private String cardNumber;
    @Basic
    @Column(name = "card_name")
    private String cardName;
    @Basic
    @Column(name = "card_valid_date")
    private String cardValidDate;

    public TourParticipant() {
    }

    public TourParticipant(int tourId, int tourDateId, String username, int quantity, Timestamp joinedTime, String cardNumber, String cardName, String cardValidDate) {
        this.tourId = tourId;
        this.tourDateId = tourDateId;
        this.username = username;
        this.quantity = quantity;
        this.joinedTime = joinedTime;
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        this.cardValidDate = cardValidDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public int getTourDateId() {
        return tourDateId;
    }

    public void setTourDateId(int tourDateId) {
        this.tourDateId = tourDateId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Timestamp getJoinedTime() {
        return joinedTime;
    }

    public void setJoinedTime(Timestamp joinedTime) {
        this.joinedTime = joinedTime;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardValidDate() {
        return cardValidDate;
    }

    public void setCardValidDate(String cardValidDate) {
        this.cardValidDate = cardValidDate;
    }

}
