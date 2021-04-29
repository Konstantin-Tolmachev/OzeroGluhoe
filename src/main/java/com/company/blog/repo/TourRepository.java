package com.company.blog.repo;

import com.company.blog.models.Tour;
import org.springframework.data.repository.CrudRepository;

public interface TourRepository extends CrudRepository <Tour, Long> {
}
