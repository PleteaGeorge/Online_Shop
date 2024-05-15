package com.example.InstantShop.repository;

import com.example.InstantShop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
public interface  ProductRepository extends JpaRepository<Product,Long>{
}
