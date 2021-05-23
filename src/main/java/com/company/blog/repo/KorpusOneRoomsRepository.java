package com.company.blog.repo;

import com.company.blog.models.KorpusOneRooms;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface KorpusOneRoomsRepository extends CrudRepository<KorpusOneRooms, Long> {

    /*Фильтр*/

    List<KorpusOneRooms> findByFreeOneKorpus (String freeOneKorpus);

    @Query("SELECT u FROM KorpusOneRooms u WHERE u.freeOneKorpus > 0")
    Collection<KorpusOneRooms> findByFreeOneKorpus1 ();
}
