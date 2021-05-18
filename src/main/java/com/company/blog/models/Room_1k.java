package com.company.blog.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Room_1k {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long roomId_1k;
    private String type_1k, free_1k;

    public Room_1k(long roomId_1k, String type_1k, String free_1k) {
        this.roomId_1k = roomId_1k;
        this.type_1k = type_1k;
        this.free_1k = free_1k;
    }


    public Room_1k() {
    }

    public long getRoomId_1k() {
        return roomId_1k;
    }

    public void setRoomId_1k(long roomId_1k) {
        this.roomId_1k = roomId_1k;
    }

    public String getType_1k() {
        return type_1k;
    }

    public void setType_1k(String type_1k) {
        this.type_1k = type_1k;
    }

    public String getFree_1k() {
        return free_1k;
    }

    public void setFree_1k(String free_1k) {
        this.free_1k = free_1k;
    }
}



//DELIMITER |
//        CREATE TRIGGER RoomsEdit AFTER INSERT ON booking
//        FOR EACH ROW
//        BEGIN
//        IF NEW.korpus = 1 THEN
//        UPDATE ozgluh.Room_1k SET free_1k=free_1k-1 WHERE Room_1k.room_id_1k=NEW.my_room_id;
//        ELSEIF NEW.korpus = 2 THEN
//        UPDATE ozgluh.Room_2k SET free_2k=free_2k-1 WHERE Room_2k.room_id_2k=NEW.my_room_id;
//        END IF;
//        END;
//        |
//        DELIMITER ;


