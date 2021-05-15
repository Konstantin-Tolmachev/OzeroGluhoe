package com.company.blog.repo;



import com.company.blog.models.Staff;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StaffRepository extends CrudRepository<Staff, Long>  {

    List<Staff> findByPosition(String position);
    List<Staff> findAllByOrderByIdDesc();
}
