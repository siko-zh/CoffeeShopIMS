package com.zholdigaliev.coffeeshopims.service;

import com.zholdigaliev.coffeeshopims.dto.StockMovementDto.StockMovementFilter;
import com.zholdigaliev.coffeeshopims.dto.StockMovementDto.StockMovementResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface StockMovementService {
    Page<StockMovementResponse> getAll(Pageable pageable);

    // Пагинация для Менеджера/Бариста (только свой филиал)
    Page<StockMovementResponse> getByBranch(Long branchId, Pageable pageable);

    StockMovementResponse getById(Long id);;

    List<StockMovementResponse> getByTimeRange(Long branchId, LocalDateTime start, LocalDateTime end);
}
