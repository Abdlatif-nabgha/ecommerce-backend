package com.nabgha.ecommercebackend;

import com.nabgha.ecommercebackend.services.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EcommerceBackendApplication {

    public static void main(String[] args) {
            SpringApplication.run(EcommerceBackendApplication.class, args);

//        var service = context.getBean(ProductService.class);
//        service.addProducts();
    }

}
