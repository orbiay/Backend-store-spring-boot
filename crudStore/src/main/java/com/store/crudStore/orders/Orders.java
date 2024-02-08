package com.store.crudStore.orders;

import com.store.crudStore.customer.Customer;
import com.store.crudStore.product.Product;
import jakarta.persistence.*;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer; // This field is what establishes the relationship between an Order and a Customer.

    public Orders() {
    }

    public Orders(Customer customer) {
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
