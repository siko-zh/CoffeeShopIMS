package com.zholdigaliev.coffeeshopims.dto.mapper;

import com.zholdigaliev.coffeeshopims.dto.ProductDto.ProductRequest;
import com.zholdigaliev.coffeeshopims.dto.ProductDto.ProductResponse;
import com.zholdigaliev.coffeeshopims.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    @Mapping(source = "category.name", target = "categoryName")
    @Mapping(source = "supplier.name", target = "supplierName")
    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "supplier.id", target = "supplierId")
    ProductResponse toResponse(Product product);

    Product toEntity(ProductRequest request);

}
