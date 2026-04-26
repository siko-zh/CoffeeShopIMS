package com.zholdigaliev.coffeeshopims.service.impl;

import com.zholdigaliev.coffeeshopims.dto.TransferDto.TransferRequest;
import com.zholdigaliev.coffeeshopims.dto.TransferDto.TransferResponse;
import com.zholdigaliev.coffeeshopims.service.TransferService;

import java.util.List;

public class TransferServiceImpl implements TransferService {
    @Override
    public TransferResponse create(TransferRequest request, Long userId) {
        return null;
    }

    @Override
    public TransferResponse complete(Long transferId) {
        return null;
    }

    @Override
    public TransferResponse cancel(Long transferId) {
        return null;
    }

    @Override
    public List<TransferResponse> getAllByBranch(Long branchId) {
        return List.of();
    }
}
