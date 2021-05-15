package com.company.blog.repo;

import com.company.blog.models.ActualInformation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ActualInformationRepository extends CrudRepository<ActualInformation, Long> {
    List<ActualInformation> findAllByOrderByIdDesc();

}
