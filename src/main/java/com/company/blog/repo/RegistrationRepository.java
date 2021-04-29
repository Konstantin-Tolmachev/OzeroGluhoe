package com.company.blog.repo;

import com.company.blog.models.Registration;
import org.springframework.data.repository.CrudRepository;

public interface RegistrationRepository extends CrudRepository<Registration, Long> {

}
