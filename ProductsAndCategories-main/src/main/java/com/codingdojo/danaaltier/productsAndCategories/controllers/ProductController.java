package com.codingdojo.danaaltier.productsAndCategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.danaaltier.productsAndCategories.models.Category;
import com.codingdojo.danaaltier.productsAndCategories.models.Product;
import com.codingdojo.danaaltier.productsAndCategories.services.CategoryService;
import com.codingdojo.danaaltier.productsAndCategories.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	// Adding the product and category services as dependencies
	private final ProductService productService;
	private final CategoryService categoryService;
	
	
	// Constructor
	public ProductController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	
	// Create new product
	@RequestMapping("/new")
	public String newProduct(Model model, @ModelAttribute("product") Product product) {
		return "newProduct.jsp";
	}
	
	@PostMapping("/new")
	public String add(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Category> categories = categoryService.getAll();
			model.addAttribute("categories", categories);
			return "redirect:/new";
		} else {
			productService.addProduct(product);
			return "redirect:/";
		}
	}
	
	
	// Get product by Id
	@RequestMapping("/{id}")
	public String showCat(Model model, @PathVariable("id") Long id) {
		Product product = productService.getOne(id);
		model.addAttribute("product", product);
		model.addAttribute("categories", categoryService.getAllExcept(id));
		return "showProduct.jsp";
	}
	
	
	// Update product
	@PostMapping("/{id}")
	public String updateProduct(@PathVariable("id") Long productId, @RequestParam("category") Long categoryId) {
		Product product = productService.getOne(productId);
		Category category = categoryService.getOne(categoryId);
		List<Category> categories = product.getCategories();
		categories.add(category);
		productService.update(product);
		return "redirect:/products/"+productId;
	}
}
