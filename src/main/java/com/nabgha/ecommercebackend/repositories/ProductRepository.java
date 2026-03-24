package com.nabgha.ecommercebackend.repositories;

import com.nabgha.ecommercebackend.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}