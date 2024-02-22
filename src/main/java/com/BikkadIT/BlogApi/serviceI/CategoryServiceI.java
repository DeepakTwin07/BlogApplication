package com.BikkadIT.BlogApi.serviceI;

import java.util.List;

import javax.persistence.Column;

import com.BikkadIT.BlogApi.payload.CategoryDto;

public interface CategoryServiceI {

	
		CategoryDto createCategory(CategoryDto categoryDto);

		CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

		void deleteCategory(Integer categoryId);

		CategoryDto getCategory(Integer categoryId);

		List<CategoryDto> getCategories();
	
	
}
