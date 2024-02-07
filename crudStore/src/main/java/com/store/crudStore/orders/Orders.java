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

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    public Orders() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
