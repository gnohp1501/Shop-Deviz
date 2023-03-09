package com.example.productservice.service;

import com.example.productservice.domain.Product;
import com.example.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;

    public ResponseEntity<List<Product>> getAll() {

        return ResponseEntity.ok().body(productRepository.getAllBy());
    }
}
