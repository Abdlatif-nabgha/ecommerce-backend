package com.nabgha.ecommercebackend.repositories;

import com.nabgha.ecommercebackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}