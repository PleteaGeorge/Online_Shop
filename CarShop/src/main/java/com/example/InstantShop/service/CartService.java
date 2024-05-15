package com.example.InstantShop.service;

import com.example.InstantShop.dto.ProductDto;
import com.example.InstantShop.entities.Cart;
import com.example.InstantShop.entities.Orders;
import com.example.InstantShop.entities.Product;
import com.example.InstantShop.entities.User;
import com.example.InstantShop.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    public Cart addToCart(Long productId, String userEmail) {
        User user = userService.findByEmail(userEmail);
        Cart cart = getCart(user);
        Product product = productService.getById(productId);
        if(cart.getProductList()==null) {
            List<Product> products = new ArrayList<>();
            cart.setProductList(products);
        }
        cart.getProductList().add(product);
        return cartRepository.save(cart);
    }
    public List<ProductDto> getAllProductsDtoByUserId(Long userId) {
        return cartRepository.findAllProductDtosInCartByUserId(userId);
    }
    public void deleteProductFromCartById(Long productId, String userEmail){
        User user = userService.findByEmail(userEmail);
        Cart cart = getCart(user);
        List<Product> list = cart.getProductList();
        Product byId = productService.getById(productId);
        list.remove(byId);
        cart.setProductList(list);
        cartRepository.save(cart);
    }
    private Cart getCart(User user) {
        Optional<Cart> byUserId = cartRepository.findByUserId(user.getId());

        if (byUserId.isEmpty()) {
            Cart cart = new Cart();
            cart.setUser(user);
            return cart;
        }
        return byUserId.get();
    }

    public Orders buy(String email) {
        User user = userService.findByEmail(email);
        Cart cart = getCart(user);
        double total = cart.getProductList().stream().mapToDouble(Product::getPrice).sum();
        deleteAllProductsFromCart(cart);
        if(total<=0){
          return null;
        }
        Orders orders = Orders.builder()
                .orderDate(LocalDate.now())
                .totalAmount(total)
                .userId(user.getId())
                .build();
       return ordersService.save(orders);
    }
    private void deleteAllProductsFromCart(Cart cart){
        cart.setProductList(new ArrayList<>());
        cartRepository.save(cart);
    }
}

