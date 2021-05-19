
package com.company.blog.repo;


import com.company.blog.models.Booking;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookingRepository extends CrudRepository<Booking, Long> {
    List<Booking> findAllByOrderByIdDesc();
    List<Booking> findByFname(String fname);
}
