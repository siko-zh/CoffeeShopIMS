package com.zholdigaliev.coffeeshopims.dto.mapper;

import com.zholdigaliev.coffeeshopims.dto.TransferDto.TransferRequest;
import com.zholdigaliev.coffeeshopims.dto.TransferDto.TransferResponse;
import com.zholdigaliev.coffeeshopims.entity.Transfer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransferMapper {
    @Mapping(source = "product.name" , target = "productName")
    @Mapping(source = "branch.name", target = "fromBranchName")
    @Mapping(source = "branch.name", target = "toBranchName")
    @Mapping(source = "user.username", target = "createdByUsername")
    TransferResponse toResponse(Transfer transfer);

    Transfer toEntity(TransferRequest request);
}
