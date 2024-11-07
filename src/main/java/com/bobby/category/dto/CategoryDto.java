package com.bobby.category.dto;

public class CategoryDto {
	
	
	
	private String name;
	
	private String imagePath;
	
	

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "CategoryDto [name=" + name + ", imagePath=" + imagePath + "]";
	}
	
	

}
