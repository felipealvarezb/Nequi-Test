package com.example.InterviewTest.mappers.implementation;

import com.example.InterviewTest.dto.FranchiseDTO;
import com.example.InterviewTest.dto.Response.FranchiseResponseDTO;
import com.example.InterviewTest.entities.Franchise;
import com.example.InterviewTest.mappers.FranchiseMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FranchiseMapperImpl implements FranchiseMapper {
  @Override
  public Franchise franchiseDtoToFranchise(FranchiseDTO franchiseDTO) {
    Franchise franchise = new Franchise();
    franchise.setName(franchiseDTO.getName());
    return franchise;
  }

  @Override
  public FranchiseResponseDTO franchiseToFranchiseResponseDTO(Franchise franchise) {
    FranchiseResponseDTO franchiseResponseDTO = new FranchiseResponseDTO();
    franchiseResponseDTO.setName(franchise.getName());
    franchiseResponseDTO.setCreatedAt(franchise.getCreatedAt());
    franchiseResponseDTO.setUpdatedAt(franchise.getUpdatedAt());
    return franchiseResponseDTO;
  }

  @Override
  public List<FranchiseResponseDTO> franchisesToFranchiseResponseDTOs(List<Franchise> franchises) {
    return franchises.stream()
            .map(this::franchiseToFranchiseResponseDTO)
            .collect(Collectors.toList());
  }
}
