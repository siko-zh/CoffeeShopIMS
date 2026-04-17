package com.zholdigaliev.coffeeshopims.dto.TransferDto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferRequest {
    private Long productId;

    private Long fromBranchId;

    private Long toBranchId;

    private BigDecimal quantity;
}
