package com.example.ecommerce.features.cart.controller;

import com.example.ecommerce.features.cart.model.Cart;
import com.example.ecommerce.features.cart.service.CartService;
import com.example.ecommerce.features.cart.dto.request.CartRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/cart")
public class CartController {

    private final CartService cartService ;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/createCart")
    public ResponseEntity<Cart> createOrder(@RequestBody CartRequest cartRequest) {
        Cart cart = cartService.createCart(cartRequest);
        return ResponseEntity.ok(cart);
    }
}
