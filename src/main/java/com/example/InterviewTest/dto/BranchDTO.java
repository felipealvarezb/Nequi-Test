package com.example.InterviewTest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchDTO {

  @NotBlank(message = "Name cannot be empty")
  @NotNull(message = "Name cannot be null")
  private String name;

  @NotNull(message = "Branch must have a Franchise")
  private Long franchiseId;

  private List<Long> productIds;
}
