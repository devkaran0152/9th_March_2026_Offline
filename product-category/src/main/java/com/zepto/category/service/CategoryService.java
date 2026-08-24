package com.zepto.category.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zepto.category.entity.CategoryEntity;
import com.zepto.category.repository.CategoryRepository;
import com.zepto.category.request.response.CategoryRequest;
import com.zepto.category.request.response.CategoryResponse;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	public CategoryResponse createCategory(CategoryRequest categoryRequest) {
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setName(categoryRequest.getName());
		categoryEntity.setDescription(categoryRequest.getDescription());
		categoryEntity.setStatus("Active");
		CategoryEntity responseEntiry = categoryRepository.save(categoryEntity);

		CategoryResponse categoryResponse = new CategoryResponse();
		categoryResponse.setId(responseEntiry.getId());
		categoryResponse.setName(responseEntiry.getName());
		categoryResponse.setDescription(responseEntiry.getDescription());
		categoryResponse.setStatus(responseEntiry.getStatus());

		return categoryResponse;
	}

}
