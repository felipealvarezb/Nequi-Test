package com.example.InterviewTest.mappers;

import com.example.InterviewTest.dto.BranchDTO;
import com.example.InterviewTest.dto.Response.BranchResponseDTO;
import com.example.InterviewTest.entities.Branch;

import java.util.List;

public interface BranchMapper {

  Branch branchDTOToBranch(BranchDTO branchDTO);

  BranchResponseDTO branchToBranchResponseDTO(Branch branch);

  List<BranchResponseDTO> branchesToBranchResponseDTOs(List<Branch> branches);
}
