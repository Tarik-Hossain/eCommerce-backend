package com.example.ecommerce.features.product.service;

import com.example.ecommerce.features.product.dto.request.ProductRequest;
import com.example.ecommerce.features.product.model.Product;

import java.util.Optional;

public interface ProductService {
    Product addProduct(ProductRequest  productRequest);
    Optional<Product> getProductById(Long id);  // Add this method to the service interface

}
