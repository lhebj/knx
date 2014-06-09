package com.knx.dao;

import java.util.List;

import com.knx.pojo.Category;

public interface ICategoryDAO {

	
	public void saveOrUpdateCategory(Category category);
	
	public Category findCategoryById(Long id);
	
	public void deleteCategory(Long id);
	
	public List<Category> getCategoryList(); 
}
