package com.example.InterviewTest.controllers;

import com.example.InterviewTest.dto.ProductDTO;
import com.example.InterviewTest.dto.Response.ProductResponseDTO;
import com.example.InterviewTest.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping
  public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
    List<ProductResponseDTO> products = productService.getAllProducts();
    return ResponseEntity.ok().body(products);
  }

  @GetMapping("/{productId}")
  public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long productId) {
    ProductResponseDTO product = productService.getProductById(productId);
    return ResponseEntity.ok().body(product);
  }

  @PostMapping
  public ResponseEntity<ProductResponseDTO> createProduct(@Validated @RequestBody ProductDTO product) {
    ProductResponseDTO createdProduct = productService.createProduct(product);
    return ResponseEntity.ok().body(createdProduct);
  }

  @PutMapping("/{productId}")
  public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable Long productId, @Validated @RequestBody ProductDTO product) {
    ProductResponseDTO updatedProduct = productService.updateProduct(productId, product);
    return ResponseEntity.ok().body(updatedProduct);
  }

  @DeleteMapping("/{productId}")
  public ResponseEntity<String> deleteProduct(@PathVariable Long productId) {
    String message = productService.deleteProduct(productId);
    return ResponseEntity.ok().body(message);
  }

}
