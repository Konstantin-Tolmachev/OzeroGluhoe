package com.company.blog.repo;

import com.company.blog.models.KorpusOneRooms;
import com.company.blog.models.Tour;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface TourRepository extends CrudRepository <Tour, Long> {
//    @Query("SELECT u FROM KorpusOneRooms u WHERE u.freeOneKorpus > 0")
//    Collection<KorpusOneRooms> findByFreeOneKorpus1 ();

//    @Modifying
//    @Query(value = "INSERT  INTO payment(id_booking, payment, sum) SELECT a.id, 'Оплачено',(DATEDIFF(a.dateOut, a.dateIn)+1)*b.price  FROM booking booking a INNER JOIN allPrice b ON a.korpus=b.korpus AND a.myRoomId=b.numberRoom ORDER BY id DESC LIMIT 1", nativeQuery = true)

}


//INSERT INTO payment(id_booking, payment, sum)
// SELECT a.id, 'Оплачено', (DATEDIFF(a.dateOut, a.dateIn)+1)*b.price
// FROM booking a INNER JOIN allPrice b ON a.korpus=b.korpus
// AND a.myRoomId=b.numberRoom
// ORDER BY id
// DESC LIMIT 1;

//    @Query(value = "INSERT u INTO payment(id_booking, payment, sum) SELECT a.id, 'Оплачено',(DATEDIFF(a.dateOut, a.dateIn)+1)*b.price  FROM booking booking a INNER JOIN allPrice b ON a.korpus=b.korpus AND a.myRoomId=b.numberRoom ORDER BY id DESC LIMIT 1")