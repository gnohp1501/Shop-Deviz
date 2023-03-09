package com.example.productservice.controller;

import com.example.productservice.domain.Product;
import com.example.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private final ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllImage() {
        return productService.getAll();
    }
}
