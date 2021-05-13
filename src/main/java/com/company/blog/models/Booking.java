package com.company.blog.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fname, lname, pname, phone, tourId, myRoomId, dateIn,  days;

    public Booking(String fname, String lname, String pname, String phone,
                   String tourId, String myRoomId, String dateIn, String days) {
        this.fname = fname;
        this.lname = lname;
        this.pname = pname;
        this.phone = phone;
        this.tourId = tourId;
        this.myRoomId = myRoomId;
        this.dateIn = dateIn;
        this.days = days;

    }

    public Booking() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTourId() {
        return tourId;
    }

    public void setTourId(String tourId) {
        this.tourId = tourId;
    }

    public String getMyRoomId() {
        return myRoomId;
    }

    public void setMyRoomId(String myRoomId) {
        this.myRoomId = myRoomId;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }



    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }
}

