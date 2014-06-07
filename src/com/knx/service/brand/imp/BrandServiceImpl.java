package com.knx.service.brand.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.knx.dao.IBrandDAO;
import com.knx.dao.IBrandDetailDAO;
import com.knx.pojo.Brand;
import com.knx.pojo.BrandDetail;
import com.knx.service.brand.IBrandService;
import com.knx.service.category.ICategoryService;
import com.knx.web.dto.BrandDTO;
import com.knx.web.dto.BrandDetailDTO;
import com.knx.web.util.CommonStaticConst;
import com.knx.web.util.LocalizationUtil;


@Service(value = "brandService")
public class BrandServiceImpl implements IBrandService {

	@Resource
	private IBrandDAO brandDAO;
	@Resource
	private IBrandDetailDAO brandDetailDAO;
	
	@Resource
	private ICategoryService categoryService;
	
	@Override
	public void saveOrUpdateBrand(Brand brand) {
		// TODO Auto-generated method stub
		brandDAO.saveOrUpdateBrand(brand);
	}

	@Override
	public Brand findBrandById(Long id) {
		// TODO Auto-generated method stub
		return brandDAO.findBrandById(id);
	}

	@Override
	public void deleteBrand(Long id) {
		// TODO Auto-generated method stub
		brandDAO.deleteBrand(id);
	}
	
	public  Map<String, Object> fullLogicallyDeleteBrandById(Long id, HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		Brand brand = findBrandById(id);
		if (brand == null) {
			map.put(CommonStaticConst.RETURN_MESSAGE, LocalizationUtil.getClientString("Parameter.error", request));
			map.put(CommonStaticConst.RETURN_SUCCESS, false);
			return map;
		}
		//logically delete
		brand.setIsEnabledBrd(false);
		this.saveOrUpdateBrand(brand);
				
				
		BrandDetail brandDetail = this.findBrandDetailByBrand(brand);
		if(brandDetail == null){
			map.put(CommonStaticConst.RETURN_MESSAGE, LocalizationUtil.getClientString("Parameter.error", request));
			map.put(CommonStaticConst.RETURN_SUCCESS, false);
			return map;
		}
		//logically delete
		brandDetail.setIsEnabledBrdd(false);
		this.saveOrUpdateBrandDetail(brandDetail);
		
		map.put(CommonStaticConst.RETURN_MESSAGE, "");
		map.put(CommonStaticConst.RETURN_SUCCESS, true);
		return map;
	}
	
	public  Map<String, Object> fullDeleteBrandById(Long id, HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		Brand brand = findBrandById(id);
		if (brand == null) {
			map.put(CommonStaticConst.RETURN_MESSAGE, LocalizationUtil.getClientString("Parameter.error", request));
			map.put(CommonStaticConst.RETURN_SUCCESS, false);
			return map;
		}
				
		BrandDetail brandDetail = this.findBrandDetailByBrand(brand);
		if(brandDetail == null){
			map.put(CommonStaticConst.RETURN_MESSAGE, LocalizationUtil.getClientString("Parameter.error", request));
			map.put(CommonStaticConst.RETURN_SUCCESS, false);
			return map;
		}
		this.deleteBrandDetail(brandDetail);
		this.deleteBrand(id);
		map.put(CommonStaticConst.RETURN_MESSAGE, "");
		map.put(CommonStaticConst.RETURN_SUCCESS, true);
		return map;
	}
	
	public List<BrandDTO> getBrandDTOListOrderByName(){
		List<Brand> list = brandDAO.getBrandListOrderByName();
		List<BrandDTO> dtoList = new ArrayList<BrandDTO>();
		for(Brand brand: list){
			dtoList.add(brand.toDTO());
		}
		return dtoList;
	}
	
	@Override
	public void saveOrUpdateBrandDetail(BrandDetail bd){
		brandDetailDAO.saveOrUpdateBrandDetail(bd);
	}

	@Override
	public BrandDetail findBrandDetailByBrand(Brand brand){
		return brandDetailDAO.findBrandDetailByBrand(brand);
	}

	@Override
	public void deleteBrandDetail(BrandDetail bd){
		brandDetailDAO.deleteBrandDetail(bd);
	}

	@Override
	public List<BrandDetailDTO> getBrandDetailDTOList (int start, int limit){
		List<BrandDetail> list = brandDetailDAO.getBrandDetailList(start, limit);
		List<BrandDetailDTO> dtoList = new ArrayList<BrandDetailDTO>();
		for(BrandDetail brandDetail: list){
			dtoList.add(brandDetail.toDTO());
		}
		return dtoList;
	}
	
}
