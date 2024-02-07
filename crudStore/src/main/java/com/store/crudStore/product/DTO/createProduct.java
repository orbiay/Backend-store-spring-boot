package com.store.crudStore.product.DTO;

import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated

public class createProduct {
    @NotBlank(message = "Field 'productName' cannot be blank")
    private String productName;

    @NotBlank(message = "Field 'quantity' cannot be blank")
    private int quantity;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @NotBlank(message = "Field 'price' cannot be blank")
    private int price;

    public createProduct() {
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
