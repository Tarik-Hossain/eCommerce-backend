package com.example.ecommerce.features.product.service;

import com.example.ecommerce.features.product.model.Product;

import java.util.Optional;

public interface ProductService {
    String addProduct(Product product);
    Optional<Product> getProductById(Long id);  // Add this method to the service interface

}
