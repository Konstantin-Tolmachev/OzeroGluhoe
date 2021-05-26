package com.company.blog.repo;


import com.company.blog.models.KorpusOneRooms;
import com.company.blog.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface PriceRepository extends JpaRepository <Price, Long> {

    @Query("SELECT u FROM Price u WHERE u.id <= 2")
    Collection<Price> findByPriceOne ();

    @Query("SELECT u FROM Price u WHERE u.id > 2")
    Collection<Price> findByPriceTwo ();


}
