package com.zholdigaliev.coffeeshopims.service;

import com.zholdigaliev.coffeeshopims.dto.SupplyDto.SupplyRequest;
import com.zholdigaliev.coffeeshopims.dto.SupplyDto.SupplyResponse;

import java.util.List;

public interface SupplyService {
    SupplyResponse create(SupplyRequest request);
    SupplyResponse getById(Long id);
    List<SupplyResponse> getAllByBranch(Long branchId);
    SupplyResponse receive(Long id);
    SupplyResponse cancel(Long id);
}
