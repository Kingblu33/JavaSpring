package com.codingdojo.danaaltier.productsAndCategories.repositories;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.danaaltier.productsAndCategories.models.Category;

@Repository
public interface CategoryRepo extends CrudRepository <Category, Long> {
	
}