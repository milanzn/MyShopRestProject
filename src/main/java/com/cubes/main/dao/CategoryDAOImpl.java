package com.cubes.main.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cubes.main.entity.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO{
	
	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	public List<Category> getCategories() {
		
		
		List<Category> list = entityManager.createQuery("from Category").getResultList();
		return list;
	}
	
	
	@Override
	public Category getCategory(int id) {
		Category category = entityManager.find(Category.class, id);
		return category;
	}
	
	@Transactional
	@Override
	public void saveCategory(Category category) {
		//Save
		entityManager.persist(category);
		
	}
	
	@Transactional
	@Override
	public void deleteCategory(int id) {
		/*
		Category c = entityManager.find(Category.class, id);
		entityManager.remove(c);
		*/
		
		Query query = entityManager.createQuery("delete from Category c where c.id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
		
	}
	
	@Transactional
	@Override
	public void updateCategory(Category category) {
		// Update
		entityManager.merge(category);
	}

}
