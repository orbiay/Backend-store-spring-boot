package com.store.crudStore.customer.service;

import com.store.crudStore.customer.Customer;
import com.store.crudStore.customer.DTO.createCustomer;
import com.store.crudStore.customer.DTO.updateCustomer;
import com.store.crudStore.customer.Repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class customerService {
    private final CustomerRepository repositoryCustomer;

    @Autowired
    public customerService(CustomerRepository repositoryCustomer) {
        this.repositoryCustomer = repositoryCustomer;
    }

    public Customer findById(long id) throws BadRequestException {
        Customer user = this.repositoryCustomer.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found with id"));
        return  user;
    }
    public Customer createCustomer(createCustomer user)
    {
        Customer customer = new Customer(user.getName(), user.getEmail(), user.getPassword());
        return repositoryCustomer.save(customer);
    }
    public Customer updateCustomer(updateCustomer user) {
        Customer customer = this.repositoryCustomer.findById(user.getId()).orElseThrow(() -> new EntityNotFoundException("User not found with id"));
        if (user.getName() != null)
            customer.setName(user.getName());
        if (user.getEmail() != null)
            customer.setEmail(user.getEmail());
        if (user.getPassword() != null ) {
            customer.setPassword(user.getPassword());
        }
        Customer newONe = this.repositoryCustomer.save(customer);
        return  newONe;
    }

    public void deleteCutomer(long id)
    {
        this.repositoryCustomer.deleteById(id);
    }
}
