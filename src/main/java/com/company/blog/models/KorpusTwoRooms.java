package com.company.blog.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class KorpusTwoRooms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long roomsTwoKorpusId;
    private String storeyTwoKorpus, typeTwoKorpus, freeTwoKorpus;

    public KorpusTwoRooms(long roomsTwoKorpusId, String storeyTwoKorpus, String typeTwoKorpus, String freeTwoKorpus) {
        this.roomsTwoKorpusId = roomsTwoKorpusId;
        this.storeyTwoKorpus = storeyTwoKorpus;
        this.typeTwoKorpus = typeTwoKorpus;
        this.freeTwoKorpus = freeTwoKorpus;
    }

    public KorpusTwoRooms() {
    }

    public long getRoomsTwoKorpusId() {
        return roomsTwoKorpusId;
    }

    public void setRoomsTwoKorpusId(long roomsTwoKorpusId) {
        this.roomsTwoKorpusId = roomsTwoKorpusId;
    }

    public String getStoreyTwoKorpus() {
        return storeyTwoKorpus;
    }

    public void setStoreyTwoKorpus(String storeyTwoKorpus) {
        this.storeyTwoKorpus = storeyTwoKorpus;
    }

    public String getTypeTwoKorpus() {
        return typeTwoKorpus;
    }

    public void setTypeTwoKorpus(String typeTwoKorpus) {
        this.typeTwoKorpus = typeTwoKorpus;
    }

    public String getFreeTwoKorpus() {
        return freeTwoKorpus;
    }

    public void setFreeTwoKorpus(String freeTwoKorpus) {
        this.freeTwoKorpus = freeTwoKorpus;
    }
}
