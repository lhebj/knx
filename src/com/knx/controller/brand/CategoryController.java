package com.knx.controller.brand;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.knx.web.dto.CategoryDTO;
import com.knx.web.util.CategoryUtil;
import com.knx.web.util.JSONHelperUtil;
import com.knx.web.util.ParamUtils;
@Controller
@RequestMapping("/category.do")
public class CategoryController {
	@RequestMapping(params = "action=list")
	public String list (HttpServletRequest request, HttpServletResponse response, Model model) {
		Long brandId = ParamUtils.getLongParameter(request, "brandId", 0);
		try{
			if(brandId==0){
				List<CategoryDTO> categoryDTOList = CategoryUtil.getCategoryTree();
				JSONHelperUtil.outputDTOToJSON(categoryDTOList, response);
			}else{
				//get by brandId
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
}
