package com.example.InstantShop.repository;

import com.example.InstantShop.dto.ProductDto;
import com.example.InstantShop.entities.Cart;
import com.example.InstantShop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Optional<Cart> findByUserId(Long userId);

    @Query("SELECT new com.example.InstantShop.dto.ProductDto(p.id, p.name, p.price, p.imagePath) " +
            "FROM Cart c JOIN c.productList p WHERE c.user.id = :userId")
    List<ProductDto> findAllProductDtosInCartByUserId(Long userId);

}
