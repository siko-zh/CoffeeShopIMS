package com.zholdigaliev.coffeeshopims.service;

import com.zholdigaliev.coffeeshopims.dto.ProductDto.ProductRequest;
import com.zholdigaliev.coffeeshopims.dto.ProductDto.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse create(ProductRequest request);
    List<ProductResponse> getAll();
    List<ProductResponse> getAllByCategoryId(Long categoryId);
    ProductResponse getById(Long id);
    ProductResponse update(Long id, ProductRequest request);
    void delete(Long id);
}
