package com.knx.service.category;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.knx.pojo.Category;
import com.knx.web.dto.CategoryDTO;

public interface ICategoryService {

	public void saveOrUpdateCategory(Category category);
	
	public Category findCategoryById(Long id);
	
	public void logicallyDeleteCategory(Long id);
	
	public void deleteCategory(Long id);
	
	public  Map<String, Object> fullDeleteCategoryById(Long id, HttpServletRequest request);
	
	public List<CategoryDTO> getCategoryDTOList(); 
}
