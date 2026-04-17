package com.zholdigaliev.coffeeshopims.dto.TransferDto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransferResponse {
    private Long id;

    private String productName;

    private String fromBranchName;

    private String toBranchName;

    private BigDecimal quantity;

    private String status;

    private String createdByUsername;

    private LocalDateTime createdAt;

    private LocalDateTime completedAt;
}
