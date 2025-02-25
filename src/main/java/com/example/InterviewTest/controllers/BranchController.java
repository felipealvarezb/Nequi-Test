package com.example.InterviewTest.controllers;

import com.example.InterviewTest.dto.BranchDTO;
import com.example.InterviewTest.dto.Response.BranchResponseDTO;
import com.example.InterviewTest.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/branch")
@RequiredArgsConstructor
public class BranchController {

  private final BranchService branchService;

  @GetMapping
  public ResponseEntity<List<BranchResponseDTO>> getAllBranches() {
    List<BranchResponseDTO> branches = branchService.getAllBranches();
    return ResponseEntity.ok().body(branches);
  }

  @GetMapping("/{branchId}")
  public ResponseEntity<BranchResponseDTO> getBranchById(@PathVariable Long branchId) {
    BranchResponseDTO branch = branchService.getBranchById(branchId);
    return ResponseEntity.ok().body(branch);
  }

  @PostMapping
  public ResponseEntity<BranchResponseDTO> createBranch(@Validated @RequestBody BranchDTO branch) {
    BranchResponseDTO createdBranch = branchService.createBranch(branch);
    return ResponseEntity.ok().body(createdBranch);
  }

  @PutMapping("/{branchId}")
  public ResponseEntity<BranchResponseDTO> updateBranch(@PathVariable Long branchId, @Validated @RequestBody BranchDTO branch) {
    BranchResponseDTO updatedBranch = branchService.updateBranch(branchId, branch);
    return ResponseEntity.ok().body(updatedBranch);
  }

  @DeleteMapping("/{branchId}")
  public ResponseEntity<String> deleteBranch(@PathVariable Long branchId) {
    String message = branchService.deleteBranch(branchId);
    return ResponseEntity.ok().body(message);
  }
}
