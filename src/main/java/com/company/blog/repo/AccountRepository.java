package com.company.blog.repo;

import com.company.blog.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository <Account, Long> {
    Account findByUsername (String username);
}
