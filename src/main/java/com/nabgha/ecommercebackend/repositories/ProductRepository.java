package com.nabgha.ecommercebackend.repositories;

import com.nabgha.ecommercebackend.entities.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    @NonNull
    @EntityGraph(attributePaths = "category")
    // or use this @Query("select p from Product p JOIN FETCH p.category")
    List<Product> findAll();

    @EntityGraph(attributePaths = "category")
    List<Product> findByCategoryId(Byte categoryId);
}