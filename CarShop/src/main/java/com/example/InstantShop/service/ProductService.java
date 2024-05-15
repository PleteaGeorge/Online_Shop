package com.example.InstantShop.service;

import com.example.InstantShop.dto.ProductDto;
import com.example.InstantShop.entities.Product;
import com.example.InstantShop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<ProductDto> getAllProductDtos(){
        List<ProductDto> productDtos = new ArrayList<>();
        List<Product> products = productRepository.findAll();
        for(Product product:products){
            ProductDto productDto = new ProductDto();
            productDto.setId(product.getId());
            productDto.setName(product.getName());
            productDto.setPrice((product.getPrice()));
            productDto.setDescription(product.getDescription());
            productDto.setImagePath(product.getImagePath());
            productDtos.add(productDto);
        }
        return productDtos;
    }
    public Product getById(Long productId){
        Optional<Product> optionalProduct = productRepository.findById(productId);
        return optionalProduct.orElse(null);
    }
}
