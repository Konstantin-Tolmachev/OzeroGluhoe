package com.company.blog.repo;

import com.company.blog.models.ActualInformation;
import com.company.blog.models.Request;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RequestRepository extends CrudRepository<Request, Long> {
    List<Request> findAllByOrderByIdDesc();
}
