package com.knx.web.util;

import java.util.ArrayList;
import java.util.List;

import com.knx.service.category.ICategoryService;
import com.knx.web.dto.CategoryDTO;

public class CategoryUtil {
//	private static Map<String, List<CategoryDTO>> categoryTreeCache;
	
	private static List<CategoryDTO> categoryTreeCache;

	public static List<CategoryDTO> getCategoryTree(){
		if(categoryTreeCache !=null && categoryTreeCache.size()>0 ){
			return categoryTreeCache;
		}
		updateCategoryDTOListCache();
		return categoryTreeCache;
	}
	
	/**
	 *  更新缓存  
	  * @return void
	 */
	public static void updateCategoryDTOListCache(){
		categoryTreeCache = new ArrayList<CategoryDTO>();
		ICategoryService categoryService = (ICategoryService)BeanFactoryUtil.getBean("categoryService");
		List<CategoryDTO> list = categoryService.getCategoryDTOListOrderByName();
		for(CategoryDTO dto: list){
			categoryTreeCache.add(dto);
		}
		
	}
}
