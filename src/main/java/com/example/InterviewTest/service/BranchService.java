package com.example.InterviewTest.service;

import com.example.InterviewTest.dto.BranchDTO;
import com.example.InterviewTest.dto.Response.BranchResponseDTO;

import java.util.List;

public interface BranchService {

  List<BranchResponseDTO> getAllBranches();

  BranchResponseDTO getBranchById(Long id);

  BranchResponseDTO createBranch(BranchDTO branchDTO);

  BranchResponseDTO updateBranch(Long id, BranchDTO branchDTO);

  String deleteBranch(Long id);
}
