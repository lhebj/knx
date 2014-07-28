package com.knx.controller.brand;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.knx.service.brandcategorycombination.IBrandCategoryCombinationService;
import com.knx.web.dto.CategoryDTO;
import com.knx.web.util.CategoryUtil;
import com.knx.web.util.JSONHelperUtil;
import com.knx.web.util.ParamUtils;
@Controller
@RequestMapping("/category.do")
public class CategoryController {

	@Resource(name = "brandCategoryCombinationService")
	private IBrandCategoryCombinationService brandCategoryCombinationService;
	
	@RequestMapping(params = "action=list")
	public String list (HttpServletRequest request, HttpServletResponse response, Model model) {
		Long brandId = ParamUtils.getLongParameter(request, "brandId", 0);
		try{
			List<CategoryDTO> categoryDTOList = CategoryUtil.getCategoryTree();
			if(brandId > 0){
				//get by brandId
				List<CategoryDTO> dtoList = brandCategoryCombinationService.getCategoryListByBrandId(brandId);
				for(CategoryDTO dto: categoryDTOList){
					dto.setShow(false);
					for(CategoryDTO showDto: dtoList){
						if(dto.getIdCat().longValue()==showDto.getIdCat().longValue()){
							dto.setShow(true);
						}
					}
				}
			}
			
			JSONHelperUtil.outputDTOToJSON(categoryDTOList, response);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
}
