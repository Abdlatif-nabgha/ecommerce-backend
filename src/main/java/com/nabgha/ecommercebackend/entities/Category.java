package com.nabgha.ecommercebackend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte id;
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Product> products = new HashSet<>();

    public Category(String name) {
        this.name = name;
    }
    public Category(byte id) {
        this.id = id;
    }
}
