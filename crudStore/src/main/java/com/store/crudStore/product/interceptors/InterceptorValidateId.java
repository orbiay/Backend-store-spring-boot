package com.store.crudStore.product.interceptors;

import com.store.crudStore.customer.Customer;

import com.store.crudStore.product.Product;
import com.store.crudStore.product.Service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;

import java.util.Map;

public class InterceptorValidateId implements HandlerInterceptor {
    final ProductService service;

    @Autowired
    public InterceptorValidateId(ProductService service) {
        this.service = service;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            final Object obj = request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
            if (obj instanceof Map<?,?>) {
                Map<?, ?> map = (Map<?, ?>) obj;
                Object idValue = map.get("id");
                Product product = this.service.findById(Long.valueOf((String) idValue));
                return true;
            }
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.getWriter().write("InValid Url");
            return  false;
        }catch (Exception err)
        {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            response.getWriter().write("NO Product founded With THis Id");
            return false;
        }
    }
}
