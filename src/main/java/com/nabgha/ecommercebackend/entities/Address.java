package com.nabgha.ecommercebackend.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "addresses")
@NoArgsConstructor @AllArgsConstructor @Setter @Getter @ToString @Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String zip;
    private String state;

    @ManyToOne(fetch = FetchType.LAZY) // many addresses belong to one user
    @ToString.Exclude // avoid stack overflow
    @JoinColumn(name = "user_id")
    private User user;
}
