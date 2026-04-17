package com.zholdigaliev.coffeeshopims.dto.SupplyItemDto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class SupplyItemRequest {
    private Long productId;

    private BigDecimal quantity;

    private BigDecimal unitPrice;
}
