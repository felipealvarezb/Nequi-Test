package com.example.InterviewTest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FranchiseDTO {

  @NotBlank(message = "Name cannot be empty")
  @NotNull(message = "Name cannot be null")
  private String name;
}
