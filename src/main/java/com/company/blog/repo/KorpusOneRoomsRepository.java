package com.company.blog.repo;

import com.company.blog.models.KorpusOneRooms;
import com.company.blog.models.KorpusTwoRooms;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KorpusOneRoomsRepository extends CrudRepository<KorpusOneRooms, Long> {
   // @Query(value = "SELECT * FROM KORPUSONEROOMS WHERE FREEONEROOMS !=0", nativeQuery = true)
//    KorpusOneRooms findByFreeOneKorpus (String freeOneKorpus);

    List<KorpusOneRooms> findByFreeOneKorpus (String freeOneKorpus);
}

//SELECT * FROM korpus_one_rooms WHERE free_one_korpus !=0;

//    User findByEmailAddress(String emailAddress);