package com.example.ecommerce.features.cart.repository;

import com.example.ecommerce.features.cart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
//    Cart findByUserId(Long userId);
}
