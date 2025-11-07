package com.example.ecommerce.features.order.service;

import com.example.ecommerce.features.order.dto.request.OrderRequest;
import com.example.ecommerce.features.order.model.Order;
import com.example.ecommerce.features.order.model.OrderItem;
import com.example.ecommerce.features.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setUserId(orderRequest.getUserId());
        order.setShippingAddress(orderRequest.getShippingAddress());
        order.setPaymentMethod(orderRequest.getPaymentMethod());
        order.setStatus("PENDING");

        List<OrderItem> items = (orderRequest.getItems() == null ? Collections.<OrderItem>emptyList()
                : orderRequest.getItems().stream().map(itemRequest -> {
                    OrderItem item = new OrderItem();
                    item.setProductId(itemRequest.getProductId());
                    item.setProductName("Product Name Placeholder");
                    item.setUnitPrice(itemRequest.getUnitPrice() != null ? itemRequest.getUnitPrice() : 0.0);
                    item.setQuantity(itemRequest.getQuantity() != null ? itemRequest.getQuantity() : 0);
                    item.setSubtotal(item.getUnitPrice() * item.getQuantity());
                    item.setOrder(order);
                    return item;
                }).collect(Collectors.toList()));

        double totalAmount = items.stream().mapToDouble(OrderItem::getSubtotal).sum();

        order.setItems(items);
        order.setTotalAmount(totalAmount);

        return orderRepository.save(order);
    }
}