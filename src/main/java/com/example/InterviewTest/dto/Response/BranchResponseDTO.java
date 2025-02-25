package com.example.InterviewTest.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchResponseDTO {

  private String name;
  private String franchiseName;
  private List<String> productNames;
  private Date createdAt;
  private Date updatedAt;
}
