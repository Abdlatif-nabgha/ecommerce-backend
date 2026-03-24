package com.nabgha.ecommercebackend.repositories;

import com.nabgha.ecommercebackend.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}