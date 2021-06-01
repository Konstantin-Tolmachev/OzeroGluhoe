package com.company.blog.repo;

import com.company.blog.models.Payment;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

import java.util.Collection;

public interface PaymentRepository extends CrudRepository <Payment, Long> {

    @Modifying
    @Query(value = "INSERT INTO :payment(:id_booking,:payment,:sum)" +
            "       SELECT :a.id, 1, (DATEDIFF(:dateOut, :dateIn)+1)*:b.price " +
            "       FROM :booking :a  " +
            "       INNER JOIN :AllPrice :b " +
            "       ON :a.korpus=:b.korpus " +
            "       AND :a.myRoomId=:b.numberRoom " +
            "       ORDER BY :a.id " +
            "       DESC LIMIT 1", nativeQuery = true)
    Collection<Payment> findByPayment ();
//            (@Param("id_booking")int id_booking, @Param("payment")int payment, @Param("sum")int sum);
}


//INSERT INTO payment(id_booking, payment, sum)
// SELECT a.id, 'Оплачено', (DATEDIFF(a.dateOut, a.dateIn)+1)*b.price
// FROM booking a
// INNER JOIN allPrice b
// ON a.korpus=b.korpus
// AND a.myRoomId=b.numberRoom
// ORDER BY id
// DESC LIMIT 1;

//    @Query(value = "INSERT u INTO payment(id_booking, payment, sum) SELECT a.id, 'Оплачено',(DATEDIFF(a.dateOut, a.dateIn)+1)*b.price  FROM booking booking a INNER JOIN allPrice b ON a.korpus=b.korpus AND a.myRoomId=b.numberRoom ORDER BY id DESC LIMIT 1")