package com.zholdigaliev.coffeeshopims.dto.StockDto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class StockResponse {
    private Long id;

    private Long productId;

    private String productName;

    private Long branchId;

    private String branchName;

    private BigDecimal quantity;

    private BigDecimal minQuantity;
}
