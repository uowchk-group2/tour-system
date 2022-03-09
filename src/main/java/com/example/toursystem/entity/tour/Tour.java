package com.example.toursystem.entity.tour;

import javax.persistence.*;

@Entity
public class Tour {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "host_username")
    private String hostUsername;
    @Basic
    @Column(name = "country")
    private String country;
    @Basic
    @Column(name = "days")
    private int days;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "schedule")
    private String schedule;
    @Basic
    @Column(name = "cover_photo")
    private String coverPhoto;
    @Basic
    @Column(name = "fee")
    private int fee;
    @Basic
    @Column(name = "participant_limit")
    private int participantLimit;

    public Tour() {
    }

    public Tour(String name, String hostUsername, String country, int days, String schedule, String coverPhoto, int fee, int participantLimit, String description) {
        this.name = name;
        this.hostUsername = hostUsername;
        this.country = country;
        this.days = days;
        this.schedule = schedule;
        this.coverPhoto = coverPhoto;
        this.fee = fee;
        this.participantLimit = participantLimit;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHostUsername() {
        return hostUsername;
    }

    public void setHostUsername(String hostUsername) {
        this.hostUsername = hostUsername;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getParticipantLimit() {
        return participantLimit;
    }

    public void setParticipantLimit(int participantLimit) {
        this.participantLimit = participantLimit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
