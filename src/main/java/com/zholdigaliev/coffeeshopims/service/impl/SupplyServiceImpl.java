package com.zholdigaliev.coffeeshopims.service.impl;

import com.zholdigaliev.coffeeshopims.dto.SupplyDto.SupplyRequest;
import com.zholdigaliev.coffeeshopims.dto.SupplyDto.SupplyResponse;
import com.zholdigaliev.coffeeshopims.dto.mapper.SupplyMapper;
import com.zholdigaliev.coffeeshopims.entity.Supply;
import com.zholdigaliev.coffeeshopims.repository.BranchRepository;
import com.zholdigaliev.coffeeshopims.repository.SupplyRepository;
import com.zholdigaliev.coffeeshopims.service.SupplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplyServiceImpl implements SupplyService {
    private final SupplyRepository supplyRepository;
    private final BranchRepository branchRepository;
    private final SupplyMapper mapper;

    @Override
    public SupplyResponse create(SupplyRequest request) {
        Supply supply = mapper.toEntity(request);

        Supply savedSupply = supplyRepository.save(supply);

        return mapper.toResponse(savedSupply);
    }

    @Override
    public SupplyResponse getById(Long id) {
        Supply supply = supplyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supply not found: " + id));

        return mapper.toResponse(supply);
    }

    @Override
    public List<SupplyResponse> getAllByBranch(Long branchId) {
        return supplyRepository.findAll().stream()
                .filter(s -> s.getBranch().getId().equals(branchId))
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public SupplyResponse receive(Long id) {
        return null;
    }

    @Override
    public SupplyResponse cancel(Long id) {
        return null;
    }
}
