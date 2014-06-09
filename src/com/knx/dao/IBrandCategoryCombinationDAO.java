package com.knx.dao;

import java.util.List;

import com.knx.pojo.BrandCategoryCombination;

public interface IBrandCategoryCombinationDAO {
	
	public void saveOrUpdateBrandCategoryCombination(BrandCategoryCombination brandCategoryCombination);
	
	public BrandCategoryCombination findBrandCategoryCombinationById(Long id);
	
	public BrandCategoryCombination findBrandCategoryCombination(Long brandId, Long categoryId);
	
	public void deleteBrandCategoryCombination(Long id);
	
	public void deleteBrandCategoryCombination(Long brandId, Long categoryId);
	
	public List<BrandCategoryCombination> getCategoryListByBrandId (Long brandId); 
	
	public List<BrandCategoryCombination> getBrandListByCategoryId (Long categoryId);
}
