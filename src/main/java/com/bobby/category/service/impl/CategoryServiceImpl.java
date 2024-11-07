package com.bobby.category.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bobby.category.dto.CategoryDto;
import com.bobby.category.entity.Category;
import com.bobby.category.exception.CategoryAlreadyExistsException;
import com.bobby.category.exception.ResourceNotFoundException;
import com.bobby.category.mapper.CategoryMapper;
import com.bobby.category.repository.CategoryRepository;
import com.bobby.category.service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	



	@Override
	public void CreateCategory(CategoryDto categoryDto) {
		Category category = CategoryMapper.mapToCategory(categoryDto, new Category());
	Optional<Category> optionalCategory = categoryRepository.findByName(categoryDto.getName());
	
	    if(optionalCategory.isPresent()) {
	    	throw new CategoryAlreadyExistsException("category already exists with same name"+ categoryDto.getName());
	    }
	
		category.setCreated_at(LocalDateTime.now());
		category.setCreated_by("BOBBY");
		
		categoryRepository.save(category);
		
	}




	@Override
	public CategoryDto fetchCategory(String name) {
		Category category = categoryRepository.findByName(name).orElseThrow(
				()-> new ResourceNotFoundException("Category","name",name));
	CategoryDto categoryDto =	CategoryMapper.mapToCategoryDto(category, new CategoryDto());
		return categoryDto;
	}




	@Override
	public boolean updateCategory(CategoryDto categoryDto) {
		
		
		
		Category category = categoryRepository.findByName(categoryDto.getName()).orElseThrow(
				()-> new ResourceNotFoundException("Category","name",categoryDto.getName())
				);
		
	 CategoryMapper.mapToCategory(categoryDto, category);
	 categoryRepository.save(category);
	 
	
		
//		if(optionalCategory.isPresent()) {
//			Category category = optionalCategory.get();
//			
//			CategoryMapper.mapToCategory(categoryDto, category);
//			categoryRepository.save(category);
//			isUpdated = true;
//		}
		
		
		return true;
	}




	@Override
	public boolean deleteCategory(String name) {
	Category category =	categoryRepository.findByName(name).orElseThrow(
				()-> new ResourceNotFoundException("Category","name",name)
				);
	    categoryRepository.deleteByName(name);
	    
	
		return true;
	}




	@Override
	public List<Category> fetchAllCategories() {
		
		return categoryRepository.findAll();
	}

}
