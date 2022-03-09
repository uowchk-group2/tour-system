package com.example.toursystem.entity.tour;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class TourDate {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "tour_id")
    private int tourId;
    @Basic
    @Column(name = "date")
    private Timestamp date;

    public TourDate() {
    }

    public TourDate(int tourId, Timestamp date) {
        this.tourId = tourId;
        this.date = date;
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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }


}
