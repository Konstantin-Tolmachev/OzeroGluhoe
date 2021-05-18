package com.company.blog.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Room_2k {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long    roomId_2k;
    private String type_2k, free_2k;

    public Room_2k(long roomId_2k, String type_2k, String free_2k) {
        this.roomId_2k = roomId_2k;
        this.type_2k = type_2k;
        this.free_2k = free_2k;
    }

    public Room_2k() {
    }

    public long getRoomId_2k() {
        return roomId_2k;
    }

    public void setRoomId_2k(long roomId_2k) {
        this.roomId_2k = roomId_2k;
    }

    public String getType_2k() {
        return type_2k;
    }

    public void setType_2k(String type_2k) {
        this.type_2k = type_2k;
    }

    public String getFree_2k() {
        return free_2k;
    }

    public void setFree_2k(String free_2k) {
        this.free_2k = free_2k;
    }
}
