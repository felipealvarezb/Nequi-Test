package com.example.InterviewTest.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {

  private String name;
  private int stock;
  private String branchName;
  private Date createdAt;
  private Date updatedAt;
}
