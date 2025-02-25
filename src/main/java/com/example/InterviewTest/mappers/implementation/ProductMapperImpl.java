package com.example.InterviewTest.mappers.implementation;

import com.example.InterviewTest.dto.ProductDTO;
import com.example.InterviewTest.dto.Response.ProductResponseDTO;
import com.example.InterviewTest.entities.Branch;
import com.example.InterviewTest.entities.Product;
import com.example.InterviewTest.mappers.ProductMapper;
import com.example.InterviewTest.respositories.BranchRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductMapperImpl implements ProductMapper {

  private final BranchRepository branchRepository;

  @Override
  public Product productDtoToProduct(ProductDTO productDTO) {

    Branch existingBranch = branchRepository.findById(productDTO.getBranchId())
            .orElseThrow(() -> new EntityNotFoundException("Branch not found"));

    Product product = new Product();
    product.setName(productDTO.getName());
    product.setStock(productDTO.getStock());
    product.setBranch(existingBranch);
    return product;
  }

  @Override
  public ProductResponseDTO productToProductResponseDTO(Product product) {
    ProductResponseDTO productResponseDTO = new ProductResponseDTO();
    productResponseDTO.setName(product.getName());
    productResponseDTO.setStock(product.getStock());
    productResponseDTO.setBranchName(product.getBranch().getName());
    productResponseDTO.setCreatedAt(product.getCreatedAt());
    productResponseDTO.setUpdatedAt(product.getUpdatedAt());
    return productResponseDTO;
  }

  @Override
  public List<ProductResponseDTO> productsToProductResponseDTOs(List<Product> products) {
    return products.stream()
            .map(this::productToProductResponseDTO)
            .collect(Collectors.toList());
  }
}
