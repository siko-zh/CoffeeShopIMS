package com.zholdigaliev.coffeeshopims.dto.mapper;

import com.zholdigaliev.coffeeshopims.dto.ProductDto.ProductRequest;
import com.zholdigaliev.coffeeshopims.dto.ProductDto.ProductResponse;
import com.zholdigaliev.coffeeshopims.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "category.name", target = "categoryName")
    @Mapping(source = "supplier.name", target = "supplierName")
    ProductResponse toResponse(Product product);

    ProductMapper toEntity(ProductRequest request);

}
