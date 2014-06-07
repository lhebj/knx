package com.knx.controller.brand;

import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.knx.pojo.Category;
import com.knx.service.category.ICategoryService;
import com.knx.web.util.CategoryUtil;
import com.knx.web.util.JSONHelperUtil;
import com.knx.web.util.LocalizationUtil;
import com.knx.web.util.LogUtil;
import com.knx.web.util.ParamUtils;
import com.knx.web.util.WebUtil;

@Controller
@RequestMapping("/categoryAdmin.do")
public class CategoryAdminController {

	@Resource(name = "categoryService")
	private ICategoryService categoryService;

	@RequestMapping(params = "action=save")
	public String save(HttpServletRequest request, HttpServletResponse response) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		String nameCat = ParamUtils.getParameter(request, "nameCat");

		try {
			if (nameCat == null) {
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}
			
//			String initials = nameCat.substring(0, 1);
//			if(!Character.isLetter(initials.toCharArray()[0])){
//				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
//			}

			Category category = null;
			if (id != 0) {
				category = categoryService.findCategoryById(id);
			}
			if (category == null) {
				category = new Category();
			}
			category.setNameCat(nameCat);
//			category.setInitialsCat(initials.toUpperCase());
			category.setIsEnabledCat(true);
			categoryService.saveOrUpdateCategory(category);
			LogUtil.log.info(WebUtil.getUserId(request) + " saves category id " + category.getIdCat());
			
			//update cache
			CategoryUtil.updateCategoryDTOListCache();

		} catch (Exception e) {
			e.printStackTrace();
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "saveOrUpdate false!", response);
		}

		return "redirect:/admin.do?action=manageCategory";
	}

	@RequestMapping(params = "action=delete")
	public String delete(HttpServletRequest request, HttpServletResponse response) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);		
		try {
			if (id == 0) {
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}
			
			categoryService.logicallyDeleteCategory(id);
			
//			Map<String, Object> map = categoryService.fullDeleteCategoryById(id, request);
//			if((Boolean)map.get(CommonStaticConst.RETURN_SUCCESS) == false){
//				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
//			}
			LogUtil.log.info(WebUtil.getUserId(request) + " deletes category id " + id);
			
			//update cache
			CategoryUtil.updateCategoryDTOListCache();
		} catch (Exception e) {
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "Delete false!", response);
			e.printStackTrace();
		}
		return "redirect:/admin.do?action=manageCategory";
	}
}
