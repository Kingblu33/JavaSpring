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
@RequestMapping("/")
public class CategoryController {
	
	// Adding the product and category services as dependencies
	private final ProductService productService;
	private final CategoryService categoryService;

	
	// Constructor
	public CategoryController(CategoryService categoryService, ProductService productService) {
		this.categoryService = categoryService;
		this.productService = productService;
	}
	
	
	// Index route
	@RequestMapping("")
	public String index(Model model) {
		model.addAttribute("categories", categoryService.getAll());
		model.addAttribute("products", productService.getAll());
		return "index.jsp";
	}
	
	
	// Create new category
	@RequestMapping("/categories/new")
	public String newCategory(Model model, @ModelAttribute("category") Category category) {
		return "newCategory.jsp";
	}
	
	@PostMapping("/categories/new")
	public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Product> products = productService.getAll();
			model.addAttribute("products", products);
			return "redirect:/categories/new";
		} else {
			categoryService.addCategory(category);
			return "redirect:/";
		}
	}
	
	
	// Get category by Id
	@RequestMapping("/categories/{id}")
	public String showCat(Model model, @PathVariable("id") Long id) {
		Category category = categoryService.getOne(id);
		model.addAttribute("category", category);
		model.addAttribute("products", productService.getAllExcept(id));
		return "showCategory.jsp";
	}
	
	
	// Update category
	@PostMapping("/categories/{id}")
	public String addProduct(@PathVariable("id") Long categoryId, @RequestParam("product") Long productId) {
		Category category = categoryService.getOne(categoryId);
		Product product = productService.getOne(productId);
		List<Product> products = category.getProducts();
		products.add(product);
		categoryService.update(category);
		return "redirect:/categories/"+categoryId;
	}
}
