package com.zepto.category.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zepto.category.entity.CategoryEntity;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {

	 @Query("SELECT c FROM CategoryEntity c LEFT JOIN FETCH c.products")
	//@EntityGraph(attributePaths = { "products" })
	public List<CategoryEntity> getAllCategories();

}
