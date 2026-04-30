package com.zholdigaliev.coffeeshopims.service.impl;

import com.zholdigaliev.coffeeshopims.dto.CategoryDto.CategoryRequest;
import com.zholdigaliev.coffeeshopims.dto.CategoryDto.CategoryResponse;
import com.zholdigaliev.coffeeshopims.dto.mapper.CategoryMapper;
import com.zholdigaliev.coffeeshopims.entity.Category;
import com.zholdigaliev.coffeeshopims.repository.CategoryRepository;
import com.zholdigaliev.coffeeshopims.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper mapper;

    @Override
    public CategoryResponse create(CategoryRequest request) {
        Category category = mapper.toEntity(request);
        Category saved = categoryRepository.save(category);
        return mapper.toResponse(saved);
    }

    @Override
    public List<CategoryResponse> getAll() {
        return categoryRepository.findAll().stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public CategoryResponse getById(Long id) {
        Category category = categoryRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Category not found: " + id));

        return mapper.toResponse(category);
    }

    @Override
    public CategoryResponse update(Long id, CategoryRequest request) {
        Category category = categoryRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Category not found: " + id));

        category.setName(request.getName());
        category.setDescription(request.getDescription());

        Category saved = categoryRepository.save(category);

        return mapper.toResponse(saved);
    }

    @Override
    public void delete(Long id) {
        Category category = categoryRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Category not found: " + id));
        categoryRepository.delete(category);
    }
}
