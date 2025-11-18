package com.example.ecommerce.features.product.controller;

import com.example.ecommerce.features.order.dto.request.OrderRequest;
import com.example.ecommerce.features.order.model.Order;
import com.example.ecommerce.features.product.dto.request.ProductRequest;
import com.example.ecommerce.features.product.model.Product;
import com.example.ecommerce.features.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/v1/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

@PostMapping   ("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody ProductRequest productRequest) {
     Product product=productService.addProduct(productRequest);

        return ResponseEntity.ok(product);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        // Return 404 if product is not found
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


}
