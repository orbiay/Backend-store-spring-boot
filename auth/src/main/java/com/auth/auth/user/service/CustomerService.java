package com.auth.auth.user.service;

import com.auth.auth.Entity.Customer;
import com.auth.auth.user.DTO.CreationDto;
import com.auth.auth.user.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private UsersRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public CustomerService(UsersRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }
    public Customer createUser(CreationDto user)
    {
        Customer customer = new Customer(user.getName(),user.getEmail(),passwordEncoder.encode( user.getPassword()));
        return  this.repository.save(customer);
    }
}
