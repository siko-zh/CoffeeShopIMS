package com.zholdigaliev.coffeeshopims.dto.StockDto;

import java.math.BigDecimal;

public class Response {
    private Long id;

    private Long productId;

    private String productName;

    private Long branchId;

    private Long branchName;

    private BigDecimal quantity;

    private BigDecimal minQuantity;
}
