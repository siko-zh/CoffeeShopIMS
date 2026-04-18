package com.zholdigaliev.coffeeshopims.dto.mapper;

import com.zholdigaliev.coffeeshopims.dto.ShiftDto.ShiftRequest;
import com.zholdigaliev.coffeeshopims.dto.ShiftDto.ShiftResponse;
import com.zholdigaliev.coffeeshopims.entity.Shift;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ShiftMapper {
    
    @Mapping(source = "branch.name", target = "branchName")
    @Mapping(source = "user.username", target = "openedByUsername")
    @Mapping(source = "user.username", target = "closedByUsername")
    ShiftResponse toResponse(Shift shift);
    
    Shift toEntity(ShiftRequest request);
}
