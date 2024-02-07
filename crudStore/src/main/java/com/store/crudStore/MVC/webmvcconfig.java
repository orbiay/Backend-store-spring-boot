package com.store.crudStore.MVC;

import com.store.crudStore.customer.interceptors.InterceptorCustomerValidateId;
import com.store.crudStore.customer.service.customerService;
import com.store.crudStore.product.Service.ProductService;
import com.store.crudStore.product.interceptors.InterceptorValidateId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webmvcconfig implements WebMvcConfigurer {
    final ProductService productservice;
    final customerService customerservice;
    @Autowired
    public webmvcconfig(ProductService service, customerService customerservice) {
        this.productservice = service;
        this.customerservice = customerservice;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new InterceptorValidateId(productservice)).addPathPatterns("/getProduct/{id}","delete/{id}");
        registry.addInterceptor(new InterceptorCustomerValidateId(customerservice)).addPathPatterns("/delete/Customer/{id}","/Cutomers/{id}");

    }
}
