package com.store.crudStore.orders.Repository;

import com.store.crudStore.orders.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
