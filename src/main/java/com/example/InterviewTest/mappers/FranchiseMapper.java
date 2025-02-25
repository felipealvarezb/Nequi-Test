package com.example.InterviewTest.mappers;

import com.example.InterviewTest.dto.FranchiseDTO;
import com.example.InterviewTest.dto.Response.FranchiseResponseDTO;
import com.example.InterviewTest.entities.Franchise;

import java.util.List;

public interface FranchiseMapper {

  Franchise franchiseDtoToFranchise(FranchiseDTO franchiseDTO);

  FranchiseResponseDTO franchiseToFranchiseResponseDTO(Franchise franchise);

  List<FranchiseResponseDTO> franchisesToFranchiseResponseDTOs(List<Franchise> franchises);
}
