package com.codingdojo.danaaltier.productsAndCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.danaaltier.productsAndCategories.models.Category;
import com.codingdojo.danaaltier.productsAndCategories.models.Product;
import com.codingdojo.danaaltier.productsAndCategories.repositories.CategoryRepo;
import com.codingdojo.danaaltier.productsAndCategories.repositories.ProductRepo;

@Service
public class CategoryService {
	
	// Adding the Product and Category repositories as dependencies
	private final ProductRepo productRepo;
	private final CategoryRepo categoryRepo;
	
	
	// Constructor
	public CategoryService(CategoryRepo categoryRepo, ProductRepo productRepo) {
		this.categoryRepo = categoryRepo;
		this.productRepo = productRepo;
	}
	
	
	// New category
	public void addCategory(Category category) {
		categoryRepo.save(category);
	}
	
	
	// Get all categories
	public List<Category> getAll() {
		return (List<Category>) categoryRepo.findAll();
	}
	
	
	// Get category by Id
	public Category getOne(Long id) {
		Optional<Category> category = categoryRepo.findById(id);
		if (category.isPresent()) {
			return category.get();
		}
		else {
			return null;
		}
	}
	
	
	// Update category
	public void update(Category category) {
		categoryRepo.save(category);
	}
	
	
	// Get all other products
	public List<Category> getAllExcept(Long productId) {
		List<Category> categories = this.getAll();
		Optional<Product> product = productRepo.findById(productId);
		if (product.isPresent()) {
			List<Category> productCategories = product.get().getCategories();
			categories.removeAll(productCategories);
			return categories;
		} else {
			return null;
		}
	}
}
