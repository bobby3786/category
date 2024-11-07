package com.bobby.category.mapper;

import com.bobby.category.dto.CategoryDto;
import com.bobby.category.entity.Category;

public class CategoryMapper {
	
	public static CategoryDto mapToCategoryDto(Category category,CategoryDto categoryDto) {
		categoryDto.setName(category.getName());
		categoryDto.setImagePath(category.getImagePath());
		
		return categoryDto;
	}
	
	public static Category mapToCategory(CategoryDto categoryDto,Category category) {
		category.setName(categoryDto.getName());
		category.setImagePath(categoryDto.getImagePath());
		
		return category;
	}

}
