package com.example.InterviewTest.mappers.implementation;

import com.example.InterviewTest.dto.BranchDTO;
import com.example.InterviewTest.dto.Response.BranchResponseDTO;
import com.example.InterviewTest.entities.Branch;
import com.example.InterviewTest.entities.BranchProduct;
import com.example.InterviewTest.entities.Franchise;
import com.example.InterviewTest.entities.Product;
import com.example.InterviewTest.mappers.BranchMapper;
import com.example.InterviewTest.respositories.FranchiseRepository;
import com.example.InterviewTest.respositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BranchMapperImpl implements BranchMapper {

  private final FranchiseRepository franchiseRepository;
  private final ProductRepository productRepository;

  @Override
  public Branch branchDTOToBranch(BranchDTO branchDTO) {
    Franchise existingFranchise = franchiseRepository.findById(branchDTO.getFranchiseId())
            .orElseThrow(() -> new EntityNotFoundException("Franchise not found"));

    Branch branch = new Branch();
    branch.setName(branchDTO.getName());
    branch.setFranchise(existingFranchise);

    if (branchDTO.getProductIds() != null && !branchDTO.getProductIds().isEmpty()) {
      List<Product> products = productRepository.findAllById(branchDTO.getProductIds());

      for (Product product : products) {
        product.setBranch(branch);
      }
      branch.setProducts(products);
    } else {
      branch.setProducts(new ArrayList<>());
    }

    return branch;
  }

  @Override
  public BranchResponseDTO branchToBranchResponseDTO(Branch branch) {
    String franchiseName = branch.getFranchise().getName();

    List<String> productNames = branch.getProducts() != null
            ? branch.getProducts().stream()
            .map(Product::getName)
            .collect(Collectors.toList())
            : Collections.emptyList();

    BranchResponseDTO branchResponseDTO = new BranchResponseDTO();
    branchResponseDTO.setName(branch.getName());
    branchResponseDTO.setFranchiseName(franchiseName);
    branchResponseDTO.setProductNames(productNames);
    branchResponseDTO.setCreatedAt(branch.getCreatedAt());
    branchResponseDTO.setUpdatedAt(branch.getUpdatedAt());
    return branchResponseDTO;
  }

  @Override
  public List<BranchResponseDTO> branchesToBranchResponseDTOs(List<Branch> branches) {
    return branches.stream()
            .map(this::branchToBranchResponseDTO)
            .collect(Collectors.toList());
  }
}
