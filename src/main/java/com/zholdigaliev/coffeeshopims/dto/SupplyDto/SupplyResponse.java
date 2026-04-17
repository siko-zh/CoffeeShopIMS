package com.zholdigaliev.coffeeshopims.dto.SupplyDto;

import com.zholdigaliev.coffeeshopims.dto.SupplyItemDto.SupplyItemResponse;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class SupplyResponse {
    private Long id;

    private String supplierName;

    private String branchName;

    private List<SupplyItemResponse> items;

    private String status;

    private LocalDateTime supplyDate;
    private LocalDateTime receivedAt;
}
