package com.company.blog.repo;



import com.company.blog.models.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long> {
    /*Iterable<Event> findAllByOrderByIdDesc();



    List<Event> findAllByOrderByIdDesc(); */
}

