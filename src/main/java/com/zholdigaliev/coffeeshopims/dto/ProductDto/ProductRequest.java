package com.zholdigaliev.coffeeshopims.dto.ProductDto;

import com.zholdigaliev.coffeeshopims.entity.Unit;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ProductRequest {

    private String name;

    private String description;

    private Unit unit;

    private BigDecimal price;

    private Long categoryId;

    private Long supplierId;
}
