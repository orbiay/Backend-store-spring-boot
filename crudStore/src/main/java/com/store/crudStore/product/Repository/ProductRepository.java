package com.store.crudStore.product.Repository;

import com.store.crudStore.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
