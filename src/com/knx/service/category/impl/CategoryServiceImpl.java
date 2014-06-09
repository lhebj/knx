package com.knx.service.category.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.knx.dao.ICategoryDAO;
import com.knx.pojo.Category;
import com.knx.service.category.ICategoryService;
import com.knx.service.product.IProductService;
import com.knx.web.dto.CategoryDTO;
import com.knx.web.util.CommonStaticConst;

@Service(value = "categoryService")
public class CategoryServiceImpl implements ICategoryService {


	@Resource
	private ICategoryDAO categoryDAO;
	
	@Resource(name = "productService")
	private IProductService productService;
	
	@Override
	public void saveOrUpdateCategory(Category category) {
		// TODO Auto-generated method stub
		categoryDAO.saveOrUpdateCategory(category);
	}

	@Override
	public Category findCategoryById(Long id) {
		// TODO Auto-generated method stub
		return categoryDAO.findCategoryById(id);
	}
	
	public void logicallyDeleteCategory(Long id) {
		Category category = this.findCategoryById(id);
		if(category != null){
			category.setIsEnabledCat(false);
			this.saveOrUpdateCategory(category);
		}
	}

	@Override
	public void deleteCategory(Long id) {
		// TODO Auto-generated method stub
		categoryDAO.deleteCategory(id);
	}
	
	//TODO performance tuning
	public  Map<String, Object> fullDeleteCategoryById(Long id, HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
//		List<ProductDTO> list = productService.getProductDTOListByCategoryId(0, Integer.MAX_VALUE, id);
//		for(ProductDTO dto : list){
//			map = productService.deleteFullProductById(dto.getIdPrd(), request);
//		}
//		this.deleteCategory(id);
		map.put(CommonStaticConst.RETURN_MESSAGE, "");
		map.put(CommonStaticConst.RETURN_SUCCESS, true);
		return map;
	}

	@Override
	public List<CategoryDTO> getCategoryDTOList() {
		// TODO Auto-generated method stub
		List<CategoryDTO> dtoList = new ArrayList<CategoryDTO>();
		List<Category> list = categoryDAO.getCategoryList();
		for(Category category: list){
			dtoList.add(category.toDTO());
		}
		return dtoList;
	}

}
