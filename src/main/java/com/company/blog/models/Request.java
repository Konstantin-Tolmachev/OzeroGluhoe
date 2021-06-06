package com.company.blog.models;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String level;
    private String room;

    @Column(name="text", length=1000)
    private String text;
    private String fromWhom, toWhom, status, fulfiled;
    private String createDate;
    private String endDate;

    public Request(String level, String room, String fromWhom, String text, String toWhom, String status, String fulfiled, String createDate, String endDate) {
        this.level = level;
        this.room = room;
        this.fromWhom = fromWhom;
        this.text = text;
        this.toWhom = toWhom;
        this.status = status;
        this.fulfiled = fulfiled;
        this.createDate = createDate;
        this.endDate = endDate;
    }

    public Request() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getFromWhom() {
        return fromWhom;
    }

    public void setFromWhom(String fromWhom) {
        this.fromWhom = fromWhom;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getToWhom() {
        return toWhom;
    }

    public void setToWhom(String toWhom) {
        this.toWhom = toWhom;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFulfiled() {
        return fulfiled;
    }

    public void setFulfiled(String fulfiled) {
        this.fulfiled = fulfiled;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
