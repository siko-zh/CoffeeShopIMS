package com.zholdigaliev.coffeeshopims.service.impl;

import com.zholdigaliev.coffeeshopims.dto.SupplierDto.SupplierRequest;
import com.zholdigaliev.coffeeshopims.dto.SupplierDto.SupplierResponse;
import com.zholdigaliev.coffeeshopims.dto.mapper.SupplierMapper;
import com.zholdigaliev.coffeeshopims.entity.Supplier;
import com.zholdigaliev.coffeeshopims.repository.SupplierRepository;
import com.zholdigaliev.coffeeshopims.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final SupplierMapper mapper;

    @Override
    public SupplierResponse create(SupplierRequest request) {
        Supplier supplier = supplierRepository.save(mapper.toEntity(request));

        return mapper.toResponse(supplier);
    }

    @Override
    public List<SupplierResponse> getAll() {
        return supplierRepository.findAllByIsActiveTrue().stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public SupplierResponse getById(Long id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found: " + id));

        return mapper.toResponse(supplier);
    }

    @Override
    public SupplierResponse update(Long id, SupplierRequest request) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found: " + id));

        supplier.setName(request.getName());
        supplier.setEmail(request.getEmail());
        supplier.setPhone(request.getPhone());
        supplier.setContactName(request.getContactName());

        Supplier saved = supplierRepository.save(supplier);

        return mapper.toResponse(saved);
    }

    @Override
    public void delete(Long id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found: " + id));

        supplier.setActive(false);

        supplierRepository.save(supplier);
    }
}
