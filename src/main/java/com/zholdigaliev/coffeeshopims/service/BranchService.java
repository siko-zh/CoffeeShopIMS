package com.zholdigaliev.coffeeshopims.service;

import com.zholdigaliev.coffeeshopims.dto.BranchDto.BranchRequest;
import com.zholdigaliev.coffeeshopims.dto.BranchDto.BranchResponse;

import java.util.List;

public interface BranchService {
    BranchResponse create(BranchRequest request);
    List<BranchResponse> getAll();
    BranchResponse getById(Long id);
    BranchResponse update(Long id, BranchRequest request);
    void delete(Long id);
}
