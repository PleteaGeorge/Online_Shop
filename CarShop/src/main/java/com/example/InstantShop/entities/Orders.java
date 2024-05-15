package com.example.InstantShop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    @Column(unique = true) // Add this annotation to make id unique
    private Long id;
    private LocalDate orderDate;
    private double totalAmount;
    private Long userId;
}
