package com.store.crudStore.orders.Service;

import com.store.crudStore.customer.Customer;
import com.store.crudStore.orders.Orders;
import com.store.crudStore.orders.Repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {
    final private OrdersRepository repository;
    @Autowired
    public OrdersService(OrdersRepository repository) {
        this.repository = repository;
    }
    public Orders createOrder(Customer customer)
    {
        Orders order = new Orders(customer);
        return  this.repository.save(order);
    }
    public  void DeletOrder(long id)
    {
        this.repository.deleteById(id);
    }
}
