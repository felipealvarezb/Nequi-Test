package com.example.InterviewTest.service.implementation;

import com.example.InterviewTest.dto.BranchDTO;
import com.example.InterviewTest.dto.Response.BranchResponseDTO;
import com.example.InterviewTest.entities.Branch;
import com.example.InterviewTest.entities.Franchise;
import com.example.InterviewTest.entities.Product;
import com.example.InterviewTest.mappers.BranchMapper;
import com.example.InterviewTest.respositories.BranchRepository;
import com.example.InterviewTest.respositories.FranchiseRepository;
import com.example.InterviewTest.respositories.ProductRepository;
import com.example.InterviewTest.service.BranchService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

  private final BranchRepository branchRepository;
  private final FranchiseRepository franchiseRepository;
  private final ProductRepository productRepository;
  private final BranchMapper branchMapper;

  @Override
  public List<BranchResponseDTO> getAllBranches() {
   List<Branch> branches = branchRepository.findAll();

   return branchMapper.branchesToBranchResponseDTOs(branches);
  }

  @Override
  public BranchResponseDTO getBranchById(Long id) {
    Branch existingBranch = branchRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Branch not found"));

    return branchMapper.branchToBranchResponseDTO(existingBranch);
  }

  @Override
  public BranchResponseDTO createBranch(BranchDTO branchDTO) {
    Branch branch = branchMapper.branchDTOToBranch(branchDTO);
    Branch savedBranch = branchRepository.save(branch);

    return branchMapper.branchToBranchResponseDTO(savedBranch);
  }

  @Override
  public BranchResponseDTO updateBranch(Long id, BranchDTO branchDTO) {
    Branch existingBranch = branchRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Branch not found"));

    Franchise existingFranchise = franchiseRepository.findById(branchDTO.getFranchiseId())
            .orElseThrow(() -> new EntityNotFoundException("Franchise not found"));


    existingBranch.setName(branchDTO.getName());
    existingBranch.setFranchise(existingFranchise);

    if (branchDTO.getProductIds() != null) {
      List<Product> products = productRepository.findAllById(branchDTO.getProductIds());
      existingBranch.setProducts(products);
    }

    branchRepository.save(existingBranch);

    return branchMapper.branchToBranchResponseDTO(existingBranch);
  }

  @Override
  public String deleteBranch(Long id) {
    Branch existingBranch = branchRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Branch not found"));

    branchRepository.delete(existingBranch);
    return "Branch deleted successfully";
  }

}
