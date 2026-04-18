package com.zholdigaliev.coffeeshopims.dto.mapper;

import com.zholdigaliev.coffeeshopims.dto.BranchDto.ProductRequest;
import com.zholdigaliev.coffeeshopims.dto.BranchDto.ProductResponse;
import com.zholdigaliev.coffeeshopims.entity.Branch;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BranchMapper {
    ProductResponse toResponse(Branch branch);

    Branch toEntity(ProductRequest request);
}
