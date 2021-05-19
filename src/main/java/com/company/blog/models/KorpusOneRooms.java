package com.company.blog.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class KorpusOneRooms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long roomsOneKorpusId;
    private String typeOneKorpus, freeOneKorpus;

    public KorpusOneRooms(long roomsOneKorpusId, String typeOneKorpus, String freeOneKorpus) {
        this.roomsOneKorpusId = roomsOneKorpusId;
        this.typeOneKorpus = typeOneKorpus;
        this.freeOneKorpus = freeOneKorpus;
    }

    public KorpusOneRooms() {
    }

    public long getRoomsOneKorpusId() {
        return roomsOneKorpusId;
    }

    public void setRoomsOneKorpusId(long roomsOneKorpusId) {
        this.roomsOneKorpusId = roomsOneKorpusId;
    }

    public String getTypeOneKorpus() {
        return typeOneKorpus;
    }

    public void setTypeOneKorpus(String typeOneKorpus) {
        this.typeOneKorpus = typeOneKorpus;
    }

    public String getFreeOneKorpus() {
        return freeOneKorpus;
    }

    public void setFreeOneKorpus(String freeOneKorpus) {
        this.freeOneKorpus = freeOneKorpus;
    }
}





//        DELIMITER |
//        CREATE TRIGGER RoomsEdit AFTER INSERT ON booking
//        FOR EACH ROW
//        BEGIN
//        IF NEW.korpus = 1 THEN
//        UPDATE ozgluh.korpus_one_rooms SET free_one_korpus=free_one_korpus-1 WHERE korpus_one_rooms.rooms_one_korpus_id=NEW.my_room_id;
//        ELSEIF NEW.korpus = 2 THEN
//        UPDATE ozgluh.korpus_two_rooms SET free_two_korpus=free_two_korpus-1 WHERE korpus_two_rooms.rooms_two_korpus_id=NEW.my_room_id;
//        END IF;
//        END;
//        |
//        DELIMITER ;


//    SELECT rooms_one_korpus_id, type_one_korpus, free_one_korpus, rooms_two_korpus_id, type_two_korpus, free_two_korpus FROM korpus_one_rooms, korpus_two_rooms WHERE rooms_one_korpus_id = rooms_two_korpus_id;

//    SELECT rooms_one_korpus_id, type_one_korpus, free_one_korpus, rooms_two_korpus_id, type_two_korpus, free_two_korpus FROM korpus_one_rooms, korpus_two_rooms WHERE rooms_one_korpus_id = rooms_two_korpus_id AND free_one_korpus !=0;




// !!!   SELECT rooms_one_korpus_id, type_one_korpus, free_one_korpus FROM korpus_one_rooms WHERE free_one_korpus != 0;