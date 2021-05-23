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
    private int typeTwoKorpus, freeTwoKorpus;

    public KorpusTwoRooms(long roomsTwoKorpusId, int typeTwoKorpus, int freeTwoKorpus) {
        this.roomsTwoKorpusId = roomsTwoKorpusId;
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

    public int getTypeTwoKorpus() {
        return typeTwoKorpus;
    }

    public void setTypeTwoKorpus(int typeTwoKorpus) {
        this.typeTwoKorpus = typeTwoKorpus;
    }

    public int getFreeTwoKorpus() {
        return freeTwoKorpus;
    }

    public void setFreeTwoKorpus(int freeTwoKorpus) {
        this.freeTwoKorpus = freeTwoKorpus;
    }
}
