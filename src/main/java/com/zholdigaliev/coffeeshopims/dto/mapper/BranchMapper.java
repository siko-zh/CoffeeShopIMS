package com.zholdigaliev.coffeeshopims.dto.mapper;

import com.zholdigaliev.coffeeshopims.dto.BranchDto.BranchRequest;
import com.zholdigaliev.coffeeshopims.dto.BranchDto.BranchResponse;
import com.zholdigaliev.coffeeshopims.entity.Branch;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BranchMapper {
    BranchResponse toResponse(Branch branch);

    Branch toEntity(BranchRequest request);
}
