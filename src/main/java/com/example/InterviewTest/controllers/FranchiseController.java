package com.example.InterviewTest.controllers;

import com.example.InterviewTest.dto.FranchiseDTO;
import com.example.InterviewTest.dto.Response.FranchiseResponseDTO;
import com.example.InterviewTest.service.FranchiseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/franchise")
@RequiredArgsConstructor
public class FranchiseController {

  private final FranchiseService franchiseService;


  @GetMapping
  public ResponseEntity<List<FranchiseResponseDTO>> getAllFranchises() {
    List<FranchiseResponseDTO> franchises = franchiseService.getAllFranchises();
    return ResponseEntity.ok().body(franchises);
  }

  @GetMapping("/{franchiseId}")
  public ResponseEntity<FranchiseResponseDTO> getFranchiseById(@PathVariable Long franchiseId) {
    FranchiseResponseDTO franchise = franchiseService.getFranchiseById(franchiseId);
    return ResponseEntity.ok().body(franchise);
  }

  @PostMapping
  public ResponseEntity<FranchiseResponseDTO> createFranchise(@RequestBody FranchiseDTO franchise) {
    FranchiseResponseDTO createdFranchise = franchiseService.createFranchise(franchise);
    return ResponseEntity.ok().body(createdFranchise);
  }

  @PutMapping("/{franchiseId}")
  public ResponseEntity<FranchiseResponseDTO> updateFranchise(@PathVariable Long franchiseId, @RequestBody FranchiseDTO franchise) {
    FranchiseResponseDTO updatedFranchise = franchiseService.updateFranchise(franchiseId, franchise);
    return ResponseEntity.ok().body(updatedFranchise);
  }

  @DeleteMapping("/{franchiseId}")
  public ResponseEntity<String> deleteFranchise(@PathVariable Long franchiseId) {
    String message = franchiseService.deleteFranchise(franchiseId);
    return ResponseEntity.ok().body(message);
  }

}
