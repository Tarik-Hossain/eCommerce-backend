package com.example.ecommerce.features.product.service;

import com.example.ecommerce.features.product.model.Product;
import com.example.ecommerce.features.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private  final ProductRepository productRepository;

    public ProductServiceImpl (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String addProduct(Product product) {
        productRepository.save(product);
        return "Product added successfully!";
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);  // Use the repository method to find the product
    }

}
