package com.example.InterviewTest.service;

import com.example.InterviewTest.dto.FranchiseDTO;
import com.example.InterviewTest.dto.Response.FranchiseResponseDTO;

import java.util.List;

public interface FranchiseService {

  List<FranchiseResponseDTO> getAllFranchises();

  FranchiseResponseDTO getFranchiseById(Long id);

  FranchiseResponseDTO createFranchise(FranchiseDTO franchiseDTO);

  FranchiseResponseDTO updateFranchise(Long id, FranchiseDTO franchiseDTO);

  String deleteFranchise(Long id);
}
