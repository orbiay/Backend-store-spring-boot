package com.auth.auth.user.Repository;

import com.auth.auth.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Customer, Long> {
    Customer findByName(String name);
}
