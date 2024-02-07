package com.store.crudStore.customer.Controller;

import com.store.crudStore.customer.Customer;
import com.store.crudStore.customer.DTO.createCustomer;
import com.store.crudStore.customer.DTO.updateCustomer;
import com.store.crudStore.customer.service.customerService;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class CustomerController {

    private final customerService  customeservice;
    public CustomerController(customerService customeservicee) {
        this.customeservice = customeservicee;
    }

    @GetMapping("/hello")
    public String showMessage() {
        return "messageView"; // This would typically be the name of a Thymeleaf or JSP view
    }
    @PostMapping("/signUp")
    public ResponseEntity<?> cretaeCustomer(@RequestBody createCustomer user) throws BadRequestException {
        try {
            final Customer customer = customeservice.createCustomer(user);
            return ResponseEntity.ok(customer);
        }catch (Exception err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("In valid Data");
        }
    }

    @GetMapping("/Cutomers/{id}")
    public ResponseEntity<?> getUser(@PathVariable long id) throws BadRequestException {
        try {
            final Customer customer = customeservice.findById(id);
            return ResponseEntity.ok(customer);
        }catch (Exception err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getMessage());
        }
    }
    @PutMapping("/update/customer")
    public ResponseEntity<?> updateUser(@RequestBody updateCustomer user)
    {
        try {
            final Customer customer = customeservice.updateCustomer(user);
            return ResponseEntity.ok(customer);
        }catch (Exception err)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getMessage());
        }
    }
    @DeleteMapping("/delete/Customer/{id}")
    public  ResponseEntity<?> updateUser(@PathVariable long id)
    {
        try {
            this.customeservice.deleteCutomer(id);
            return ResponseEntity.ok("Deleted Successfully");
        }catch (Exception err)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getMessage());
        }
    }
}
