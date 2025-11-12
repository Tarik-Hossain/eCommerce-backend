package com.example.ecommerce.features.product.controller;

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
    public ResponseEntity<String> addProduct(@RequestBody ProductRequest productRequest) {

        Product product = new Product();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setStock(productRequest.getStock());
        String response = productService.addProduct(product);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            return ResponseEntity.notFound().build();  // Return 404 if product is not found
        }
    }


}
