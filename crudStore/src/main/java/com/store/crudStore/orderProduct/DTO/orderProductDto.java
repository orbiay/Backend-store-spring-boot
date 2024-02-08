package com.store.crudStore.orderProduct.DTO;

import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public class orderProductDto {
    @NotBlank(message = "Field 'customerId' cannot be blank")
    long customerId;
    @NotBlank(message = "Field 'productId' cannot be blank")
    long productId;

    public orderProductDto(long customerId, long productId) {
        this.customerId = customerId;
        this.productId = productId;
    }

    public orderProductDto() {
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
