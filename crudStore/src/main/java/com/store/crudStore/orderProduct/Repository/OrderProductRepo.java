package com.store.crudStore.orderProduct.Repository;

import com.store.crudStore.orderProduct.OrderProduct;
import com.store.crudStore.orders.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepo extends JpaRepository<OrderProduct, Long> {
}
