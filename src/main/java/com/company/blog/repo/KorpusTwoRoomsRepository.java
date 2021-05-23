package com.company.blog.repo;


import com.company.blog.models.KorpusTwoRooms;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface KorpusTwoRoomsRepository extends CrudRepository<KorpusTwoRooms, Long> {
    List<KorpusTwoRooms> findByFreeTwoKorpus (String freeTwoKorpus);

    @Query("SELECT u FROM KorpusTwoRooms u WHERE u.freeTwoKorpus > 0")
    Collection<KorpusTwoRooms> findByFreeTwoKorpus2 ();


}
