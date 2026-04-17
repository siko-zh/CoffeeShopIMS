package com.zholdigaliev.coffeeshopims.dto.SupplyDto;


import com.zholdigaliev.coffeeshopims.dto.SupplyItemDto.SupplyItemRequest;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class SupplyRequest {

    private Long supplierId;

    private Long branchId;

    private List<SupplyItemRequest> items;

    private LocalDateTime supplyDate;
}
