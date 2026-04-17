package com.zholdigaliev.coffeeshopims.dto.SupplyItemDto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class SupplyItemResponse {
    private Long id;

    private Long productId;

    private String productName;

    private BigDecimal quantity;

    private BigDecimal unitPrice;

    private BigDecimal totalPrice;
}
