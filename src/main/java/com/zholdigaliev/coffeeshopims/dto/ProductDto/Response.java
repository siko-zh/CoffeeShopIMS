package com.zholdigaliev.coffeeshopims.dto.ProductDto;

import com.zholdigaliev.coffeeshopims.entity.Unit;

import java.math.BigDecimal;

public class Response {

    private Long id;

    private String name;

    private String description;

    private Unit unit;

    private BigDecimal price;

    private Long categoryId;

    private String categoryName;

    private Long supplierId;

    private String supplierName;
}
