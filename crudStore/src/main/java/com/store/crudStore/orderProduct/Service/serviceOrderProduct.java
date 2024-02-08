package com.store.crudStore.orderProduct.Service;

import com.store.crudStore.customer.Customer;
import com.store.crudStore.customer.service.customerService;
import com.store.crudStore.orderProduct.DTO.orderProductDto;
import com.store.crudStore.orderProduct.OrderProduct;
import com.store.crudStore.orderProduct.OrderProduct;
import com.store.crudStore.orderProduct.Repository.OrderProductRepo;
import com.store.crudStore.orders.Orders;
import com.store.crudStore.orders.Service.OrdersService;
import com.store.crudStore.product.Product;
import com.store.crudStore.product.Service.ProductService;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

@Service
public class serviceOrderProduct {
    private final OrderProductRepo repository;
    private final OrdersService orderservice;
    private final customerService customerservice;
    private final ProductService productservice;

    public serviceOrderProduct(OrderProductRepo repository, OrdersService orderservice, customerService customerservice, ProductService productservice) {
        this.repository = repository;
        this.orderservice = orderservice;
        this.customerservice = customerservice;
        this.productservice = productservice;
    }
    public OrderProduct orderproduct(orderProductDto orderproduct) throws BadRequestException {
        Customer customer = this.customerservice.findById(orderproduct.getCustomerId());
        Product product = this.productservice.findById(orderproduct.getProductId());
        product = this.productservice.decreaseQuantity(product);
        Orders order = this.orderservice.createOrder(customer);
        OrderProduct  saveorder = new OrderProduct(order,product,5);
        return this.repository.save(saveorder);
    }
}
