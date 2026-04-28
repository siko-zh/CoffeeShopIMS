package com.zholdigaliev.coffeeshopims.service;

import com.zholdigaliev.coffeeshopims.dto.ShiftDto.ShiftRequest;
import com.zholdigaliev.coffeeshopims.dto.ShiftDto.ShiftResponse;
import com.zholdigaliev.coffeeshopims.dto.StockMovementDto.StockMovementResponse;

import java.util.List;

public interface ShiftService {
    ShiftResponse openedByUser(Long userId, ShiftRequest request);
    ShiftResponse closedByUser(Long id, Long userId);
    ShiftResponse getActiveByBranch(Long branchId);
    List<ShiftResponse> getAllByBranch(Long branchId);
    List<StockMovementResponse> getMovementsByShift(Long id);
}
