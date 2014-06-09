package com.knx.service.brandcategorycombination;

import java.util.List;

import com.knx.pojo.BrandCategoryCombination;
import com.knx.web.dto.BrandDTO;
import com.knx.web.dto.CategoryDTO;

public interface IBrandCategoryCombinationService {
public void saveOrUpdateBrandCategoryCombination(BrandCategoryCombination brandCategoryCombination);
	
	public BrandCategoryCombination findBrandCategoryCombinationById(Long id);
	
	public BrandCategoryCombination findBrandCategoryCombination(Long brandId, Long categoryId);
	
	public void deleteBrandCategoryCombination(Long id);
	
	public void deleteBrandCategoryCombination(Long brandId, Long categoryId);
	
	public List<CategoryDTO> getCategoryListByBrandId (Long brandId); 
	
	public List<BrandDTO> getBrandListByCategoryId (Long categoryId);
}
