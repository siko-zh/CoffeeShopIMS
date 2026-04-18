package com.zholdigaliev.coffeeshopims.dto.mapper;

import com.zholdigaliev.coffeeshopims.dto.SupplyItemDto.SupplyItemRequest;
import com.zholdigaliev.coffeeshopims.dto.SupplyItemDto.SupplyItemResponse;
import com.zholdigaliev.coffeeshopims.entity.SupplyItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SupplyItemMapper {
    @Mapping(source = "product.name", target = "productName")
    SupplyItemResponse toResponse(SupplyItem supplyItem);

    SupplyItem toEntity(SupplyItemRequest request);
}
