package com.company.blog.repo;

import com.company.blog.models.KorpusTwoRooms;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KorpusTwoRoomsRepository extends CrudRepository<KorpusTwoRooms, Long> {
    List<KorpusTwoRooms> findByFreeTwoKorpus (String freeTwoKorpus);


}
