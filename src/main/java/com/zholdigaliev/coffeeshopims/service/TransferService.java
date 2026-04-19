package com.zholdigaliev.coffeeshopims.service;

import com.zholdigaliev.coffeeshopims.dto.TransferDto.TransferRequest;
import com.zholdigaliev.coffeeshopims.dto.TransferDto.TransferResponse;

import java.util.List;

public interface TransferService {
    TransferResponse create(TransferRequest request, Long userId);
    TransferResponse complete(Long transferId);
    TransferResponse cancel(Long transferId);
    List<TransferResponse> getAllByBranch(Long branchId);
}
