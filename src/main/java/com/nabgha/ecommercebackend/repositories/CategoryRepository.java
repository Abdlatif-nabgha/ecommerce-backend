package com.nabgha.ecommercebackend.repositories;

import com.nabgha.ecommercebackend.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Byte> {
}