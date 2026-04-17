package com.zholdigaliev.coffeeshopims.dto.ProductDto;

import com.zholdigaliev.coffeeshopims.entity.Unit;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ProductResponse {

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
