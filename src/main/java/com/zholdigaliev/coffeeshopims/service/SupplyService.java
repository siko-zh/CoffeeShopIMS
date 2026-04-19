package com.zholdigaliev.coffeeshopims.service;

import com.zholdigaliev.coffeeshopims.dto.SupplyDto.SupplyRequest;
import com.zholdigaliev.coffeeshopims.dto.SupplyDto.SupplyResponse;

public interface SupplyService {
    SupplyResponse create(Long createdByUserId, SupplyRequest request);
    SupplyResponse getAllByBranch(Long branchId);
    SupplyResponse getById(Long id);
    SupplyResponse receive(Long id);
    SupplyResponse cancel(Long id);
}
