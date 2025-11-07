package com.example.ecommerce.features.product.repository;

import com.example.ecommerce.features.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
