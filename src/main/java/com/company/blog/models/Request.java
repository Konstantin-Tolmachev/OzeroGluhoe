package com.company.blog.models;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;


@Entity
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long request_id;
    @CreationTimestamp
    private Timestamp createDate;
    private String korpus;
    private String myRoomId;
    private String textRequest;
    private String toWhom;
    @CreationTimestamp
    private Timestamp createEndDate;
    private String fulfilled;

    public Request(Timestamp createDate, String korpus, String myRoomId, String textRequest,
                    String toWhom, Timestamp createEndDate, String fulfilled) {
        this.createDate=createDate;
        this.korpus = korpus;
        this.myRoomId = myRoomId;
        this.textRequest = textRequest;
        this.toWhom = toWhom;
        this.createEndDate = createEndDate;
        this.fulfilled = fulfilled;
    }

    public Request(){

    }


    public Long getRequest_id() {
        return request_id;
    }

    public void setRequest_id(Long request_id) {
        this.request_id = request_id;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public String getKorpus() {
        return korpus;
    }

    public void setKorpus(String korpus) {
        this.korpus = korpus;
    }

    public String getMyRoomId() {
        return myRoomId;
    }

    public void setMyRoomId(String myRoomId) {
        this.myRoomId = myRoomId;
    }

    public String getTextRequest() {
        return textRequest;
    }

    public void setTextRequest(String textRequest) {
        this.textRequest = textRequest;
    }

    public String getToWhom() {
        return toWhom;
    }

    public void setToWhom(String toWhom) {
        this.toWhom = toWhom;
    }

    public Timestamp getCreateEndDate() {
        return createEndDate;
    }

    public void setCreateEndDate(Timestamp createEndDate) {
        this.createEndDate = createEndDate;
    }

    public String getFulfilled() {
        return fulfilled;
    }

    public void setFulfilled(String fulfilled) {
        this.fulfilled = fulfilled;
    }
}
