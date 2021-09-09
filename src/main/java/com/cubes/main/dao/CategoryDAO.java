package com.cubes.main.dao;

import java.util.List;

import com.cubes.main.entity.Category;

public interface CategoryDAO {
	
	public List<Category> getCategories();
	public Category getCategory(int id);
	public void saveCategory(Category category);
	public void deleteCategory(int id);
	public void updateCategory(Category category);
}
