package com.nabgha.ecommercebackend.repositories;

import com.nabgha.ecommercebackend.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}