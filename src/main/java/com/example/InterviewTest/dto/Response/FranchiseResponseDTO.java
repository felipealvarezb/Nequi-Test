package com.example.InterviewTest.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FranchiseResponseDTO {

  private String name;
  private Date createdAt;
  private Date updatedAt;
}
