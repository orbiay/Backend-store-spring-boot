package com.store.crudStore.orderProduct.Controller;

import com.store.crudStore.orderProduct.OrderProduct;
import com.store.crudStore.orderProduct.Service.serviceOrderProduct;
import org.springframework.http.HttpStatus;
import com.store.crudStore.orderProduct.DTO.orderProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orderProduct")
public class orderProductController {
    private final serviceOrderProduct service;


    public orderProductController(serviceOrderProduct service) {
        this.service = service;
    }

    @PostMapping("/newOrder")
    public ResponseEntity<?> newOrder(@RequestBody orderProductDto newOrder){
        try {
            final OrderProduct shop =  this.service.orderproduct(newOrder);
            return ResponseEntity.ok(shop);
        }catch (Exception err)
        {
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("In valid Data");
        }
    }
}
