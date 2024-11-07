package com.bobby.category.service;

import java.util.List;

import com.bobby.category.dto.CategoryDto;
import com.bobby.category.entity.Category;

public interface ICategoryService {
	
	void CreateCategory(CategoryDto categoryDto);
	CategoryDto fetchCategory(String name);
	boolean updateCategory(CategoryDto categoryDto);
	boolean deleteCategory(String name);
	List<Category> fetchAllCategories();

}
