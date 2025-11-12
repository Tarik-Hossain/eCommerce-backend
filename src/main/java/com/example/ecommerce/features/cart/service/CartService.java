package com.example.ecommerce.features.cart.service;

import com.example.ecommerce.features.cart.dto.request.CartItemRequest;
import com.example.ecommerce.features.cart.dto.request.CartRequest;
import com.example.ecommerce.features.cart.model.Cart;
import com.example.ecommerce.features.order.dto.request.OrderRequest;
import com.example.ecommerce.features.order.model.Order;

import java.util.List;

public interface CartService {
    Cart createCart(CartRequest cartRequest);

//    Cart getOrCreateCart(Long userId);
//    Cart addOrUpdateItems(Long cartId, List<CartItemRequest> items);
//    Cart removeItem(Long cartId, Long itemId);
//    Cart getCartByUser(Long userId);
//    Order checkoutCart(Long cartId);
}


