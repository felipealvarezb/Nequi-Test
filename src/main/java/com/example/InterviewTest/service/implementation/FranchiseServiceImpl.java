package com.example.InterviewTest.service.implementation;

import com.example.InterviewTest.dto.FranchiseDTO;
import com.example.InterviewTest.dto.Response.FranchiseResponseDTO;
import com.example.InterviewTest.entities.Franchise;
import com.example.InterviewTest.mappers.FranchiseMapper;
import com.example.InterviewTest.respositories.FranchiseRepository;
import com.example.InterviewTest.service.FranchiseService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FranchiseServiceImpl implements FranchiseService {

  private final FranchiseRepository franchiseRepository;
  private final FranchiseMapper franchiseMapper;

  @Override
  public List<FranchiseResponseDTO> getAllFranchises() {
    List<Franchise> franchises = franchiseRepository.findAll();

    return franchiseMapper.franchisesToFranchiseResponseDTOs(franchises);
  }

  @Override
  public FranchiseResponseDTO getFranchiseById(Long id) {
    Franchise existingFranchise = franchiseRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Franchise not found"));

    return franchiseMapper.franchiseToFranchiseResponseDTO(existingFranchise);
  }

  @Override
  public FranchiseResponseDTO createFranchise(FranchiseDTO franchiseDTO) {
    Franchise franchise = franchiseMapper.franchiseDtoToFranchise(franchiseDTO);
    Franchise savedFranchise = franchiseRepository.save(franchise);

    return franchiseMapper.franchiseToFranchiseResponseDTO(savedFranchise);
  }

  @Override
  public FranchiseResponseDTO updateFranchise(Long id, FranchiseDTO franchiseDTO) {
    Franchise existingFranchise = franchiseRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Franchise not found"));

    existingFranchise.setName(franchiseDTO.getName());
    franchiseRepository.save(existingFranchise);

    return franchiseMapper.franchiseToFranchiseResponseDTO(existingFranchise);
  }

  @Override
  public String deleteFranchise(Long id) {
    Franchise existingFranchise = franchiseRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Franchise not found"));

    franchiseRepository.delete(existingFranchise);
    return "Franchise deleted successfully";
  }
}
