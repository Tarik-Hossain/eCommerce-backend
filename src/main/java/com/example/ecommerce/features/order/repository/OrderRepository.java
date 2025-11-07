package com.example.ecommerce.features.order.repository;

import com.example.ecommerce.features.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
