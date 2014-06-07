package com.knx.dao;

import java.util.List;

import com.knx.pojo.Brand;

public interface IBrandDAO {

	
	public void saveOrUpdateBrand(Brand brand);
	
	public Brand findBrandById(Long id);
	
	public void deleteBrand(Long id);
	
	public List<Brand> getBrandList (int start, int limit); 
	
	public List<Brand> getBrandListOrderByName ();
}
