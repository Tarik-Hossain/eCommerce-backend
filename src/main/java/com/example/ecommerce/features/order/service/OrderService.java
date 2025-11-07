package com.example.ecommerce.features.order.service;

import com.example.ecommerce.features.order.dto.request.OrderRequest;
import com.example.ecommerce.features.order.model.Order;

public interface OrderService {
    Order createOrder(OrderRequest orderRequest);
}
