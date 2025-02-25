package com.example.InterviewTest.mappers;

import com.example.InterviewTest.dto.ProductDTO;
import com.example.InterviewTest.dto.Response.ProductResponseDTO;
import com.example.InterviewTest.entities.Product;

import java.util.List;

public interface ProductMapper {

  Product productDtoToProduct(ProductDTO productDTO);

  ProductResponseDTO productToProductResponseDTO(Product product);

  List<ProductResponseDTO> productsToProductResponseDTOs(List<Product> products);
}
