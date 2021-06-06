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
    private String storeyOneKorpus, typeOneKorpus, freeOneKorpus;

    public KorpusOneRooms(long roomsOneKorpusId, String storeyOneKorpus, String typeOneKorpus, String freeOneKorpus) {
        this.roomsOneKorpusId = roomsOneKorpusId;
        this.storeyOneKorpus = storeyOneKorpus;
        this.typeOneKorpus = typeOneKorpus;
        this.freeOneKorpus = freeOneKorpus;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        KorpusOneRooms that = (KorpusOneRooms) o;
//
//        if (roomsOneKorpusId != that.roomsOneKorpusId) return false;
//        if (typeOneKorpus != null ? !typeOneKorpus.equals(that.typeOneKorpus) : that.typeOneKorpus != null)
//            return false;
//        return freeOneKorpus != null ? freeOneKorpus.equals(that.freeOneKorpus) : that.freeOneKorpus == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = (int) (roomsOneKorpusId ^ (roomsOneKorpusId >>> 32));
//        result = 31 * result + (typeOneKorpus != null ? typeOneKorpus.hashCode() : 0);
//        result = 31 * result + (freeOneKorpus != null ? freeOneKorpus.hashCode() : 0);
//        return result;
//    }

    public KorpusOneRooms() {
    }

    public long getRoomsOneKorpusId() {
        return roomsOneKorpusId;
    }

    public void setRoomsOneKorpusId(long roomsOneKorpusId) {
        this.roomsOneKorpusId = roomsOneKorpusId;
    }

    public String getStoreyOneKorpus() {
        return storeyOneKorpus;
    }

    public void setStoreyOneKorpus(String storeyOneKorpus) {
        this.storeyOneKorpus = storeyOneKorpus;
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


//        DELIMITER |
//        CREATE EVENT UpdateOneKorpus
//        ON SCHEDULE
//        EVERY 1 DAY
//        STARTS '2021-05-30 00:00:00'
//        ON COMPLETION PRESERVE
//        DO
//        BEGIN
//        UPDATE korpus_one_rooms a INNER JOIN booking b ON a.rooms_one_korpus_id = b.my_room_id SET a.free_one_korpus = IF (b.date_out = CURRENT_DATE() AND b.korpus = 1, a.free_one_korpus + 1, a.free_one_korpus);
//        END |
//        DELIMITER ;


//        DELIMITER |
//        CREATE EVENT UpdateTwoKorpus
//        ON SCHEDULE
//        EVERY 1 DAY
//        STARTS '2021-05-30 00:00:00'
//        ON COMPLETION PRESERVE
//        DO
//        BEGIN
//        UPDATE korpus_two_rooms a INNER JOIN booking b ON a.rooms_two_korpus_id = b.my_room_id SET a.free_two_korpus = IF (b.date_out = CURRENT_DATE() AND b.korpus = 2, a.free_two_korpus + 1, a.free_two_korpus);
//        END |
//        DELIMITER ;




//    SELECT rooms_one_korpus_id, type_one_korpus, free_one_korpus, rooms_two_korpus_id, type_two_korpus, free_two_korpus FROM korpus_one_rooms, korpus_two_rooms WHERE rooms_one_korpus_id = rooms_two_korpus_id;

//    SELECT rooms_one_korpus_id, type_one_korpus, free_one_korpus, rooms_two_korpus_id, type_two_korpus, free_two_korpus FROM korpus_one_rooms, korpus_two_rooms WHERE rooms_one_korpus_id = rooms_two_korpus_id AND free_one_korpus !=0;




// !!!   SELECT rooms_one_korpus_id, type_one_korpus, free_one_korpus FROM korpus_one_rooms WHERE free_one_korpus != 0;