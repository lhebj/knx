package com.knx.service.brand;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.knx.pojo.Brand;
import com.knx.pojo.BrandDetail;
import com.knx.web.dto.BrandDTO;
import com.knx.web.dto.BrandDetailDTO;

public interface IBrandService {


	public void saveOrUpdateBrand(Brand brand);
	
	public Brand findBrandById(Long id);
	
	public void deleteBrand(Long id);
	
	public  Map<String, Object> fullLogicallyDeleteBrandById(Long id, HttpServletRequest request);
	
	public  Map<String, Object> fullDeleteBrandById(Long id, HttpServletRequest request);
	
//	public List<BrandDTO> getBrandDTOList (int start, int limit);
	
	public List<BrandDTO> getBrandDTOListOrderByName();
	
	public void saveOrUpdateBrandDetail(BrandDetail bd);
	
	public BrandDetail findBrandDetailByBrand(Brand brand);
	
	public void deleteBrandDetail(BrandDetail bd);
	
	public List<BrandDetailDTO> getBrandDetailDTOList (int start, int limit);
	
}
