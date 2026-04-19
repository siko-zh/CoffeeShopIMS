package com.zholdigaliev.coffeeshopims.service;

import com.zholdigaliev.coffeeshopims.dto.SupplierDto.SupplierRequest;
import com.zholdigaliev.coffeeshopims.dto.SupplierDto.SupplierResponse;

import java.util.List;

public interface SupplierService {
    SupplierResponse create(SupplierRequest request);
    List<SupplierResponse> getAll();
    SupplierResponse getById(Long id);
    SupplierResponse update(Long id, SupplierRequest request);
    void delete(Long id);
}
