package com.knx.web.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.knx.service.brand.IBrandService;
import com.knx.web.dto.BrandDTO;

public class BrandUtil {
	private static Map<String, List<BrandDTO>> brandTreeCache;

	public static Map<String, List<BrandDTO>> getBrandTree(){
		if(brandTreeCache !=null && brandTreeCache.size()>0 ){
			for(String key: brandTreeCache.keySet()){
				for(BrandDTO dto: brandTreeCache.get(key)){
					dto.setShow(true);
				}
			}
			return brandTreeCache;
		}
		updateBrandDTOListCache();
		return brandTreeCache;
	}
	
	/**
	 *  更新缓存  
	  * @return void
	 */
	public static void updateBrandDTOListCache(){
		brandTreeCache = new LinkedHashMap<String, List<BrandDTO>>();
		IBrandService brandService = (IBrandService)BeanFactoryUtil.getBean("brandService");
		List<BrandDTO> list = brandService.getBrandDTOListOrderByName();
		for(BrandDTO dto: list){
			List<BrandDTO> brandDTOList = brandTreeCache.get(dto.getInitialsBrd());
			if(brandDTOList == null){
				brandDTOList = new ArrayList<BrandDTO>();
			}
			brandDTOList.add(dto);
			brandTreeCache.put(dto.getInitialsBrd(), brandDTOList);
		}
		
	}
}
