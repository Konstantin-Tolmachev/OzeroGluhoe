package com.company.blog.repo;


import com.company.blog.models.Staff;
import org.springframework.data.repository.CrudRepository;

public interface StaffRepository extends CrudRepository<Staff, Long>  {
}
