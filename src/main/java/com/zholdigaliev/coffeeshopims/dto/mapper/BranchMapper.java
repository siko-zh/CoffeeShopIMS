package com.zholdigaliev.coffeeshopims.dto.mapper;

import com.zholdigaliev.coffeeshopims.dto.BranchDto.BranchRequest;
import com.zholdigaliev.coffeeshopims.dto.BranchDto.BranchResponse;
import com.zholdigaliev.coffeeshopims.entity.Branch;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BranchMapper {
    BranchResponse toResponse(Branch branch);

    Branch toEntity(BranchRequest request);
}
