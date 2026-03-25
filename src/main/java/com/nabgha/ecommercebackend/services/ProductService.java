package com.nabgha.ecommercebackend.services;


import com.nabgha.ecommercebackend.entities.Category;
import com.nabgha.ecommercebackend.entities.Product;
import com.nabgha.ecommercebackend.repositories.CategoryRepository;
import com.nabgha.ecommercebackend.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public void addProducts() {

        var clothing = new Category("Clothing");
        var food = new Category("Food");

        var tshirt = Product.builder()
                .name("T-shirt")
                .description("Casual cotton t-shirt")
                .price(BigDecimal.valueOf(200))
                .category(clothing)
                .build();

        var jeans = Product.builder()
                .name("Jeans")
                .description("Blue denim jeans")
                .price(BigDecimal.valueOf(500))
                .category(clothing)
                .build();

        var bread = Product.builder()
                .name("Bread")
                .description("Fresh bakery bread")
                .price(BigDecimal.valueOf(10))
                .category(food)
                .build();

        var milk = Product.builder()
                .name("Milk")
                .description("1 liter fresh milk")
                .price(BigDecimal.valueOf(15))
                .category(food)
                .build();

        productRepository.saveAll(List.of(tshirt, jeans, bread, milk));
    }
}
