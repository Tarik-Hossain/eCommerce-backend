package com.example.ecommerce.features.cart.service;

import com.example.ecommerce.features.cart.dto.request.CartRequest;
import com.example.ecommerce.features.cart.model.Cart;
import com.example.ecommerce.features.cart.repository.CartRepository;
import com.example.ecommerce.features.cart.model.CartItem;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository  cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart createCart(CartRequest cartRequest) {
        Cart cart = new Cart();
        cart.setUserId(cartRequest.getUserId());
//        cart.setShippingAddress(cartRequest.getShippingAddress());
//        cart.setPaymentMethod(cartRequest.getPaymentMethod());
//        cart.setStatus("PENDING");


        List<CartItem> items = (cartRequest.getItems() == null ? Collections.<CartItem>emptyList()
                : cartRequest.getItems().stream().map(itemRequest -> {
            CartItem item = new CartItem();
            item.setProductId(itemRequest.getProductId());
            item.setProductName("Product Name Placeholder");
            item.setUnitPrice(itemRequest.getUnitPrice() != null ? itemRequest.getUnitPrice() : 0.0);
            item.setQuantity(itemRequest.getQuantity() != null ? itemRequest.getQuantity() : 0);
            item.setSubtotal(item.getUnitPrice() * item.getQuantity());
            item.setCart(cart);
            return item;
        }).collect(Collectors.toList()));

        double totalAmount = items.stream().mapToDouble(CartItem::getSubtotal).sum();

        cart.setItems(items);
        cart.setTotalAmount(totalAmount);

        return cartRepository.save(cart);
    }

}

