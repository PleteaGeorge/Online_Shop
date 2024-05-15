package com.example.InstantShop.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Cart {
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @ManyToMany
    private List<Product> productList;
    @OneToOne
    private User user;
}
