package com.example.InstantShop.controller;

import com.example.InstantShop.dto.ProductDto;
import com.example.InstantShop.service.CartService;
import com.example.InstantShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;
    @GetMapping("/cart")
    public String getCart(Model model, Authentication authentication){
        Long id = userService.getIdByEmail(authentication.getName());
        List<ProductDto> productList = cartService.getAllProductsDtoByUserId(id);
        model.addAttribute("productDtos", productList);
        return "cart";
    }
    @ResponseBody
    @PostMapping("/addToCart/{productId}")
    public String addToCart(@PathVariable Long productId, Authentication authentication){
        String email=authentication.getName();
        cartService.addToCart(productId, email);
        return "method called" + productId;
    }
    @ResponseBody
    @PatchMapping("/removeFromCart/{productId}")
    public String removeProductFromCart(@PathVariable Long productId, Authentication authentication){
        String email = authentication.getName();
        cartService.deleteProductFromCartById(productId, email);
        return "removed from cart";

    }
    @PostMapping("/buy")
    public String buy (Authentication authentication){
        String email = authentication.getName();
       if(cartService.buy(email)==null) {
           throw new RuntimeException("Add some product into the cart");
       }
        return "cart";
    }
}
