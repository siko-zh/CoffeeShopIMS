package com.zholdigaliev.coffeeshopims.service.impl;

import com.zholdigaliev.coffeeshopims.dto.StockMovementDto.StockMovementFilter;
import com.zholdigaliev.coffeeshopims.dto.StockMovementDto.StockMovementResponse;
import com.zholdigaliev.coffeeshopims.dto.mapper.StockMovementMapper;
import com.zholdigaliev.coffeeshopims.entity.StockMovement;
import com.zholdigaliev.coffeeshopims.repository.StockMovementRepository;
import com.zholdigaliev.coffeeshopims.service.StockMovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockMovementServiceImpl implements StockMovementService {
    private final StockMovementRepository stockMovementRepository;
    private final StockMovementMapper mapper;

    @Override
    public Page<StockMovementResponse> getAll(Pageable pageable) {
        return stockMovementRepository.findAll(pageable)
                .map(mapper::toResponse);
    }

    @Override
    public Page<StockMovementResponse> getByBranch(Long branchId, Pageable pageable) {
        return stockMovementRepository.findAllByBranchId(branchId, pageable)
                .map(mapper::toResponse);
    }

    @Override
    public StockMovementResponse getById(Long id) {
        StockMovement movement = stockMovementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movement with id: " + id + " not found"));

        return mapper.toResponse(movement);
    }

    @Override
    public List<StockMovementResponse> getByTimeRange(Long branchId, LocalDateTime start, LocalDateTime end) {

        List<StockMovement> movements = stockMovementRepository.findAllByBranchIdAndCreatedAtBetween(branchId, start, end);

                return movements.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }
}
