package com.zholdigaliev.coffeeshopims.dto.mapper;

import com.zholdigaliev.coffeeshopims.dto.SupplyDto.SupplyRequest;
import com.zholdigaliev.coffeeshopims.dto.SupplyDto.SupplyResponse;
import com.zholdigaliev.coffeeshopims.entity.Supply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = SupplyItemMapper.class)
public interface SupplyMapper {
    @Mapping(source = "supplier.name", target = "supplierName")
    @Mapping(source = "branch.name", target = "branchName")
    SupplyResponse toResponse(Supply supply);

    Supply toEntity(SupplyRequest request);
}
