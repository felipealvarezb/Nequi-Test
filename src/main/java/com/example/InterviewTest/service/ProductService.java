package com.example.InterviewTest.service;

import com.example.InterviewTest.dto.ProductDTO;
import com.example.InterviewTest.dto.Response.ProductResponseDTO;

import java.util.List;

public interface ProductService {

  List<ProductResponseDTO> getAllProducts();

  List<ProductResponseDTO> getProductsOrderedByBranchId(Long branchId);

  ProductResponseDTO getProductById(Long id);

  ProductResponseDTO createProduct(ProductDTO productDTO);

  ProductResponseDTO updateProduct(Long id, ProductDTO productDTO);

  String deleteProduct(Long id);
}
