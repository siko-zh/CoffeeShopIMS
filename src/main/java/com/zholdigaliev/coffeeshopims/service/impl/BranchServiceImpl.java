package com.zholdigaliev.coffeeshopims.service.impl;

import com.zholdigaliev.coffeeshopims.dto.BranchDto.BranchRequest;
import com.zholdigaliev.coffeeshopims.dto.BranchDto.BranchResponse;
import com.zholdigaliev.coffeeshopims.dto.mapper.BranchMapper;
import com.zholdigaliev.coffeeshopims.entity.Branch;
import com.zholdigaliev.coffeeshopims.repository.BranchRepository;
import com.zholdigaliev.coffeeshopims.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {
    private final BranchRepository branchRepository;
    private final BranchMapper mapper;

    @Override
    public BranchResponse create(BranchRequest request) {
        Branch branch = branchRepository.save(mapper.toEntity(request));

        return mapper.toResponse(branch);
    }

    @Override
    public List<BranchResponse> getAll() {
        return branchRepository.findAll().stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public BranchResponse getById(Long id) {
        Branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Branch not found: " + id));
        return mapper.toResponse(branch);
    }

    @Override
    public BranchResponse update(Long id, BranchRequest request) {
        Branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Branch not found: " + id));

        branch.setName(request.getName());
        branch.setAddress(request.getAddress());
        branch.setPhone(request.getPhone());

        Branch saved = branchRepository.save(branch);

        return mapper.toResponse(saved);
    }

    @Override
    public void delete(Long id) {
        Branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Branch not found: " + id));

        branchRepository.delete(branch);
    }
}
