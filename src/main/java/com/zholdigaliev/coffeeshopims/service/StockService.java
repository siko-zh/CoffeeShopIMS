package com.zholdigaliev.coffeeshopims.service;

import com.zholdigaliev.coffeeshopims.dto.StockDto.StockResponse;

import java.math.BigDecimal;
import java.util.List;

public interface StockService {
    List<StockResponse> getByBranch(Long branchId);
    List<StockResponse> getLowStock(Long branchId);
    StockResponse setMinQuantity(Long id, BigDecimal minQuantity);
    StockResponse writeOff(Long id, BigDecimal quantity, String reason);
}
