package com.store.crudStore.customer.Repository;

import com.store.crudStore.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
