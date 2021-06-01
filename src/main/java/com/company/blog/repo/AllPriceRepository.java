package com.company.blog.repo;

import com.company.blog.models.Payment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface AllPriceRepository extends CrudRepository <Payment, Long> {
//    @Query("SELECT u FROM KorpusOneRooms u WHERE u.freeOneKorpus > 0")
//    Collection<KorpusOneRooms> findByFreeOneKorpus1 ();

//    @Modifying
//    @Query(value = "INSERT  INTO Payment(id_booking, payment, sum) SELECT a.id, 1,(DATEDIFF(a.dateOut, a.dateIn)+1)*b.price  FROM Booking a INNER JOIN Price b ON a.korpus=b.korpus AND a.myRoomId=b.numberRoom ORDER BY id DESC LIMIT 1", nativeQuery = true)
//    Collection<Payment> findByPayment ();

}


//INSERT INTO payment(id_booking, payment, sum)
// SELECT a.id, 'Оплачено', (DATEDIFF(a.dateOut, a.dateIn)+1)*b.price
// FROM booking a INNER JOIN allPrice b ON a.korpus=b.korpus
// AND a.myRoomId=b.numberRoom
// ORDER BY id
// DESC LIMIT 1;

//    @Query(value = "INSERT u INTO payment(id_booking, payment, sum) SELECT a.id, 'Оплачено',(DATEDIFF(a.dateOut, a.dateIn)+1)*b.price  FROM booking booking a INNER JOIN allPrice b ON a.korpus=b.korpus AND a.myRoomId=b.numberRoom ORDER BY id DESC LIMIT 1")