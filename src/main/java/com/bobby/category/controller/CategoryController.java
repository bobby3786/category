package com.bobby.category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bobby.category.constants.CategoryConstants;
import com.bobby.category.dto.ApiResponse;
import com.bobby.category.dto.CategoryDto;
import com.bobby.category.dto.ResponseDto;
import com.bobby.category.entity.Category;
import com.bobby.category.service.ICategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {
	@Autowired
	private ICategoryService iCategoryService;
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDto> createCategory(@RequestBody CategoryDto categoryDto){
		
		iCategoryService.CreateCategory(categoryDto);
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseDto(CategoryConstants.STATUS_201,CategoryConstants.MESSAGE_201));
		
	}
	
	@GetMapping("/fetch")
	public ResponseEntity<CategoryDto> fetchCategoryDetails(@RequestParam String name){
		
		CategoryDto categoryDto = iCategoryService.fetchCategory(name);
		
		return ResponseEntity.status(HttpStatus.OK).body(categoryDto);
		
		       
		    
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseDto> updateCategoryDetails(@RequestBody CategoryDto categoryDto){
		
		boolean isUpdated = iCategoryService.updateCategory(categoryDto);
		
		if(isUpdated) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ResponseDto(CategoryConstants.STATUS_200,CategoryConstants.MESSAGE_200));
		}else {
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ResponseDto(CategoryConstants.STATUS_500,CategoryConstants.MESSAGE_500));
		}
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseDto> deleteCategoryDetails(@RequestParam String name){
		
		boolean isDeleted = iCategoryService.deleteCategory(name);
		
		if(isDeleted) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ResponseDto(CategoryConstants.STATUS_200,CategoryConstants.MESSAGE_200));
		}else {
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ResponseDto(CategoryConstants.STATUS_500,CategoryConstants.MESSAGE_500));
		}
	}
	
	@GetMapping("/All")
    public ApiResponse<List<Category>> getAllCategories() {
        List<Category> categories = iCategoryService.fetchAllCategories();
        
        return new ApiResponse("200","success",categories);
    }

}
