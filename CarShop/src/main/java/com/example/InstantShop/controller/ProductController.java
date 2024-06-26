package com.example.InstantShop.controller;

import com.example.InstantShop.dto.ProductDto;
import com.example.InstantShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public String getProducts(Model model){
        List<ProductDto> productDtoList = productService.getAllProductDtos();
        model.addAttribute("productList", productDtoList);
        productDtoList.forEach(p -> System.out.println(p.getImagePath()));
        return "products";
    }
}
