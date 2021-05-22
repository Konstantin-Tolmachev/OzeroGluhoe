package com.company.blog.repo;

import com.company.blog.models.KorpusOneRooms;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KorpusOneRoomsRepository extends CrudRepository<KorpusOneRooms, Long> {
    List<KorpusOneRooms> findByFreeOneKorpus (String freeOneKorpus);

}
