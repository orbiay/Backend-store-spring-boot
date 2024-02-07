package com.store.crudStore.product.Controler;

import com.store.crudStore.product.DTO.createProduct;
import com.store.crudStore.product.Product;
import com.store.crudStore.product.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/Product")
public class ProductController {
    final private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> GetAll()
    {
        try {
            return ResponseEntity.ok(this.service.getAll());
        }catch (Exception err)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getMessage());
        }
    }
    @PostMapping("/createPrduct")
    public ResponseEntity<?> createProduct(@RequestBody createProduct product)
    {
        try {
            return ResponseEntity.ok(this.service.createProduct(product));
        }catch (Exception err)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getMessage());
        }
    }
    @GetMapping("/getProduct/{id}")
    public ResponseEntity<?> getProduct(@PathVariable long id)
    {
        try {
            return ResponseEntity.ok(this.service.findById(id));
        }catch (Exception err)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getMessage());
        }
    }
    @GetMapping("/addQuantity")
    public ResponseEntity<?> addQuantity(@RequestParam(name = "id", required = true) long id,
                                         @RequestParam(name = "quantity", required = true) int quantity)
    {
        try {
            return ResponseEntity.ok(this.service.addQuantity(id,quantity));
        }catch (Exception err)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getMessage());
        }
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable long id)
    {
        try {
            this.service.deleteProduct(id);
            return ResponseEntity.ok("Deleted successfully");
        }catch (Exception err)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getMessage());
        }
    }
}
