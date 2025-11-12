package com.example.ecommerce.features.cart.model;

import com.example.ecommerce.features.order.model.OrderItem;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Double totalAmount = 0.0;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<CartItem> items;// = new ArrayList<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(Double totalAmount) { this.totalAmount = totalAmount; }

    public List<CartItem> getItems() { return items; }
    public void setItems(List<CartItem> items) { this.items = items; }


//    public void addItem(CartItem item) {
//        item.setCart(this);
//        this.items.add(item);
//    }
//
//    public void removeItem(CartItem item) {
//        this.items.remove(item);
//        item.setCart(null);
//    }
//
//    public void recalculateTotal() {
//        this.totalAmount = items.stream()
//                .mapToDouble(CartItem::getSubtotal)
//                .sum();
//    }
}