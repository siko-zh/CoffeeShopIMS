package com.zholdigaliev.coffeeshopims.dto.mapper;

import com.zholdigaliev.coffeeshopims.dto.SupplierDto.SupplierRequest;
import com.zholdigaliev.coffeeshopims.dto.SupplierDto.SupplierResponse;
import com.zholdigaliev.coffeeshopims.entity.Supplier;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    SupplierResponse toResponse(Supplier supplier);

    Supplier toEntity(SupplierRequest request);
}
