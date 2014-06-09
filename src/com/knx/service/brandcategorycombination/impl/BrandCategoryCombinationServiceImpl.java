package com.knx.service.brandcategorycombination.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.knx.dao.IBrandCategoryCombinationDAO;
import com.knx.pojo.Brand;
import com.knx.pojo.BrandCategoryCombination;
import com.knx.pojo.Category;
import com.knx.service.brandcategorycombination.IBrandCategoryCombinationService;
import com.knx.web.dto.BrandDTO;
import com.knx.web.dto.CategoryDTO;


@Service(value = "brandCategoryCombinationService")
public class BrandCategoryCombinationServiceImpl implements IBrandCategoryCombinationService {
	@Resource
	private IBrandCategoryCombinationDAO brandCategoryCombinationDAO;
	
	@Override
	public void saveOrUpdateBrandCategoryCombination(BrandCategoryCombination brandCategoryCombination) {
		// TODO Auto-generated method stub
		brandCategoryCombinationDAO.saveOrUpdateBrandCategoryCombination(brandCategoryCombination);
	}

	@Override
	public BrandCategoryCombination findBrandCategoryCombinationById(Long id) {
		// TODO Auto-generated method stub
		return brandCategoryCombinationDAO.findBrandCategoryCombinationById(id);
	}
	
	@Override
	public BrandCategoryCombination findBrandCategoryCombination(Long brandId, Long categoryId){
		return brandCategoryCombinationDAO.findBrandCategoryCombination(brandId, categoryId);
	}

	@Override
	public void deleteBrandCategoryCombination(Long id) {
		// TODO Auto-generated method stub
		brandCategoryCombinationDAO.deleteBrandCategoryCombination(id);
	}
	
	public void deleteBrandCategoryCombination(Long brandId, Long categoryId){
		brandCategoryCombinationDAO.deleteBrandCategoryCombination(brandId, categoryId);
	}

	@Override
	public List<CategoryDTO> getCategoryListByBrandId(Long brandId) {
		// TODO Auto-generated method stub
		List<CategoryDTO> dtoList = new ArrayList<CategoryDTO>();
		List<BrandCategoryCombination> list = brandCategoryCombinationDAO.getCategoryListByBrandId(brandId);
		for(BrandCategoryCombination bcc: list){
			dtoList.add(bcc.getCategory().toDTO());
		}
		return dtoList;
	}

	@Override
	public List<BrandDTO> getBrandListByCategoryId(Long categoryId) {
		// TODO Auto-generated method stub
		List<BrandCategoryCombination> list = brandCategoryCombinationDAO.getBrandListByCategoryId(categoryId);
		List<BrandDTO> dtoList = new ArrayList<BrandDTO>();
		for(BrandCategoryCombination bcc: list){
			dtoList.add(bcc.getBrand().toDTO());
		}
		return dtoList;
	}

}
