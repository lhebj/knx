package com.knx.dao;

import java.util.List;

import com.knx.pojo.Brand;
import com.knx.pojo.BrandDetail;

public interface IBrandDetailDAO {
	
	public void saveOrUpdateBrandDetail(BrandDetail bd);
	
	public BrandDetail findBrandDetailByBrand(Brand brand);
	
	public void deleteBrandDetail(BrandDetail bd);
	
	public List<BrandDetail> getBrandDetailList (int start, int limit);

}
