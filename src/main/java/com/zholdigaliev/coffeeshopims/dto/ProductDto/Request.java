package com.zholdigaliev.coffeeshopims.dto.ProductDto;

import com.zholdigaliev.coffeeshopims.entity.Unit;

import java.math.BigDecimal;

public class Request {

    private String name;

    private Unit unit;

    private BigDecimal price;

    private Long categoryId;

    private Long supplierId;
}
