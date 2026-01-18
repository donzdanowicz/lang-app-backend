package com.langapp.mapper;

import com.langapp.domain.category.Category;
import com.langapp.domain.category.dto.CategoryDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryMapper {

    public Category mapToCategory(final CategoryDto categoryDto) {
        return Category.builder()
                .id(categoryDto.getId())
                .name(categoryDto.getName())
                .badgeImageUrl(categoryDto.getBadgeImageUrl())
                .build();
    }

    public CategoryDto mapToCategoryDto(final Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .badgeImageUrl(category.getBadgeImageUrl())
                .build();
    }

    public List<CategoryDto> mapToCategoryDtoList(final List<Category> categories) {
        return categories.stream()
                .map(this::mapToCategoryDto)
                .collect(Collectors.toList());
    }
}
