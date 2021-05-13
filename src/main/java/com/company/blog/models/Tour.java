package com.company.blog.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String tourKorpus, tourDateIn, tourDateOut,  tourDays,  tourName;

    public Tour (String tourKorpus, String tourDateIn, String tourDateOut, String tourDays, String tourName) {
        this.tourKorpus = tourKorpus;
        this.tourDateIn = tourDateIn;
        this.tourDateOut = tourDateOut;
        this.tourDays = tourDays;
        this.tourName = tourName;
    }

    public Tour() {

    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTourKorpus() {
        return tourKorpus;
    }
    public void setTourKorpus(String tourKorpus) {
        this.tourKorpus = tourKorpus;
    }

    public String getTourDateIn() {
        return tourDateIn;
    }
    public void setTourDateIn(String tourDateIn) {
        this.tourDateIn = tourDateIn;
    }

    public String getTourDateOut() {
        return tourDateOut;
    }
    public void setTourDateOut(String tourDateOut) {
        this.tourDateOut = tourDateOut;
    }

    public String getTourDays() {
        return tourDays;
    }
    public void setTourDays(String tourDays) {
        this.tourDays = tourDays;
    }

    public String getTourName() {
        return tourName;
    }
    public void setTourName(String tourName) {
        this.tourName = tourName;
    }


}
