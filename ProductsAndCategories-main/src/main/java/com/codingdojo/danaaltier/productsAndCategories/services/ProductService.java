package com.codingdojo.danaaltier.productsAndCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.danaaltier.productsAndCategories.models.Category;
import com.codingdojo.danaaltier.productsAndCategories.models.Product;
import com.codingdojo.danaaltier.productsAndCategories.repositories.CategoryRepo;
import com.codingdojo.danaaltier.productsAndCategories.repositories.ProductRepo;

@Service
public class ProductService {
	
	// Adding the Product and Category repositories as dependencies
	private final ProductRepo productRepo;
	private final CategoryRepo categoryRepo;
	
	
	// Constructor
	public ProductService(ProductRepo productRepo, CategoryRepo categoryRepo) {
		this.productRepo = productRepo;
		this.categoryRepo = categoryRepo;
	}
	
	
	
	// New product
	public void addProduct(Product product) {
		productRepo.save(product);
	}
		
	
	// Get all products
	public List<Product> getAll(){
		return (List<Product>) productRepo.findAll();
	}
	
	
	// Get one product by Id
	public Product getOne(Long id) {
		Optional<Product> product = productRepo.findById(id);
		if (product.isPresent()) {
			return product.get();
		}
		else {
			return null;
		}
	}
	
	
	// Update product
	public void update(Product product) {
		productRepo.save(product);
	}
	
	
	// Get all other categories
	public List<Product> getAllExcept(Long categoryId) {
		List<Product> products = this.getAll();
		Optional<Category> category = categoryRepo.findById(categoryId);
		if (category.isPresent()) { 
			List<Product> categoryProducts = category.get().getProducts();
			products.removeAll(categoryProducts);
			return products;
		} else {
			return null;
		}
	}
}