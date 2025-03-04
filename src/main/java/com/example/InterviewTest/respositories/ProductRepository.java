package com.example.InterviewTest.respositories;

import com.example.InterviewTest.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  @Query("SELECT p FROM Product p WHERE p.branch.id = :branchId ORDER BY p.stock DESC")
  List<Product> getProductsOrderedByStockDesc(Long branchId);
}
