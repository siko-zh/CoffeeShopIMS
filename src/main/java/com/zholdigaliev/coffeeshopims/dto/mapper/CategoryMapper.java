package com.zholdigaliev.coffeeshopims.dto.mapper;

import com.zholdigaliev.coffeeshopims.dto.CategoryDto.CategoryRequest;
import com.zholdigaliev.coffeeshopims.dto.CategoryDto.CategoryResponse;
import com.zholdigaliev.coffeeshopims.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toEntity(CategoryRequest request);

    CategoryResponse toResponse(Category category);
}
