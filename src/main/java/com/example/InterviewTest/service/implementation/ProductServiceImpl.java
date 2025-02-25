package com.example.InterviewTest.service.implementation;

import com.example.InterviewTest.dto.ProductDTO;
import com.example.InterviewTest.dto.Response.ProductResponseDTO;
import com.example.InterviewTest.entities.Branch;
import com.example.InterviewTest.entities.Product;
import com.example.InterviewTest.mappers.ProductMapper;
import com.example.InterviewTest.respositories.BranchRepository;
import com.example.InterviewTest.respositories.ProductRepository;
import com.example.InterviewTest.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;
  private final BranchRepository branchRepository;
  private final ProductMapper productMapper;

  @Override
  public List<ProductResponseDTO> getAllProducts() {
    List<Product> products = productRepository.findAll();
    return productMapper.productsToProductResponseDTOs(products);
  }

  @Override
  public List<ProductResponseDTO> getProductsOrderedByBranchId(Long branchId) {
    List<Product> products = productRepository.getProductsOrderedByStockDesc(branchId);
    return productMapper.productsToProductResponseDTOs(products);
  }

  @Override
  public ProductResponseDTO getProductById(Long id) {
    Product existingProduct = productRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Product not found"));

    return productMapper.productToProductResponseDTO(existingProduct);
  }

  @Override
  public ProductResponseDTO createProduct(ProductDTO productDTO) {
    Product product = productMapper.productDtoToProduct(productDTO);
    Product savedProduct = productRepository.save(product);

    return productMapper.productToProductResponseDTO(savedProduct);
  }

  @Override
  public ProductResponseDTO updateProduct(Long id, ProductDTO productDTO) {
    Product existingProduct = productRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Product not found"));

    existingProduct.setName(productDTO.getName());
    existingProduct.setStock(productDTO.getStock());

    if (productDTO.getBranchId() != null && productDTO.getBranchId() != existingProduct.getBranch().getId()) {
      Branch newBranch = branchRepository.findById(productDTO.getBranchId())
              .orElseThrow(() -> new EntityNotFoundException("Branch not found"));

      existingProduct.setBranch(newBranch);
    }

    productRepository.save(existingProduct);

    return productMapper.productToProductResponseDTO(existingProduct);
  }

  @Override
  public String deleteProduct(Long id) {
    Product existingProduct = productRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Product not found"));

    productRepository.delete(existingProduct);
    return "Product deleted successfully";
  }
}
