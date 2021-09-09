package com.cubes.main.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cubes.main.dao.CategoryDAO;
import com.cubes.main.entity.Category;

@RestController
@RequestMapping(value = "/api")
public class MyRestController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@GetMapping(value = "/categories")
	public List<Category> getCategories() {
		
		return categoryDAO.getCategories();
	}
	
	@GetMapping(value = "/categories/{id}")
	public Category getCategory(@PathVariable int id) {
		
		return categoryDAO.getCategory(id);
	}
	
	@PostMapping(value = "/categories")
	public Category saveCategory(@RequestBody Category category) {
		category.setId(0);
		categoryDAO.saveCategory(category);
		
		return category;
	}
	
	@PutMapping(value = "/categories")
	public Category updateCategory(@RequestBody Category category) {
		
		categoryDAO.updateCategory(category);
		return category;
		
	}
	
	@DeleteMapping(value = "/categories/{id}")
	public Category deleteCategory(@PathVariable int id) {
		Category cat = categoryDAO.getCategory(id);
		
		categoryDAO.deleteCategory(id);
		
		return cat;
	}
	

}
