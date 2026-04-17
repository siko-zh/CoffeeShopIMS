package com.zholdigaliev.coffeeshopims.dto.StockMovementDto;
import com.zholdigaliev.coffeeshopims.entity.MovementType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class StockMovementResponse {
    private Long id;

    private String productName;

    private String branchName;

    private Long shiftId;

    private MovementType type;

    private BigDecimal quantity;

    private String reason;

    private LocalDateTime createdAt;
}
