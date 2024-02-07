package com.store.crudStore.product.Service;

import com.store.crudStore.customer.Customer;

import com.store.crudStore.product.DTO.createProduct;
import com.store.crudStore.product.Product;
import com.store.crudStore.product.Repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    final private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }
    public Product findById(long id) throws BadRequestException {
        Product product = this.repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found with id"));
        return  product;
    }

    public Product createProduct(createProduct newproduct)
    {
        Product product = new Product(newproduct.getProductName(),newproduct.getQuantity(), newproduct.getPrice());
        Product NewOne =  repository.save(product);
        return NewOne;
    }

    public void deleteProduct(long id)
    {
        this.repository.deleteById(id);
    }

    public Product addQuantity(long id,int quantity)
    {
        Product product = this.repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found with id"));
        product.setQuantity(product.getQuantity() + quantity) ;
        Product newOne = this.repository.save(product);
        return  newOne;
    }
    public List<Product> getAll()
    {
        return  this.repository.findAll();
    }
}
