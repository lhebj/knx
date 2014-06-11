package com.knx.controller.brand;

import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.knx.pojo.Brand;
import com.knx.pojo.BrandCategoryCombination;
import com.knx.pojo.Category;
import com.knx.service.brand.IBrandService;
import com.knx.service.brandcategorycombination.IBrandCategoryCombinationService;
import com.knx.service.category.ICategoryService;
import com.knx.web.util.JSONHelperUtil;
import com.knx.web.util.LocalizationUtil;
import com.knx.web.util.LogUtil;
import com.knx.web.util.ParamUtils;
import com.knx.web.util.WebUtil;

@Controller
@RequestMapping("/brandCategoryCombinationAdmin.do")
public class BrandCategoryCombinationAdminController {

	
	@Resource(name = "brandCategoryCombinationService")
	private IBrandCategoryCombinationService brandCategoryCombinationService;
	
	
	@Resource(name = "brandService")
	private IBrandService brandService;
	
	@Resource(name = "categoryService")
	private ICategoryService categoryService;
	
	@RequestMapping(params = "action=save")
	public String save(HttpServletRequest request, HttpServletResponse response) {
		Long brandId = ParamUtils.getLongParameter(request, "brandId", 0);
		String categoryIds[] = request.getParameterValues("categoryIds");
		
		try {
			if (brandId == 0 || categoryIds.length == 0) {
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}
			Brand brand = brandService.findBrandById(brandId);
			if(brand == null){
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}
			
			for(String categoryIdStr: categoryIds){
				long categoryId = 0;
				try {
					categoryId = Long.parseLong(categoryIdStr.trim());
				} catch (Exception ignored) {
				}
				Category category = categoryService.findCategoryById(categoryId);
				if(category == null){
					continue;
				}
				BrandCategoryCombination bcc = brandCategoryCombinationService.findBrandCategoryCombination(brandId, categoryId);
				if(bcc == null){
					bcc = new BrandCategoryCombination();
					bcc.setBrand(brand);
					bcc.setCategory(category);
					brandCategoryCombinationService.saveOrUpdateBrandCategoryCombination(bcc);
					
				}
		
				LogUtil.log.info(WebUtil.getUserId(request) + " saves BrandCategoryCombination brandId=" + brandId + ", categoryId=" + categoryId);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "saveOrUpdate false!", response);
		}
		return "redirect:/admin.do?action=manageBrandCategoryCombination&brandId="+brandId;
	}

	@RequestMapping(params = "action=delete")
	public String delete(HttpServletRequest request, HttpServletResponse response) {
		Long brandId = ParamUtils.getLongParameter(request, "brandId", 0);
		String categoryIds[] = request.getParameterValues("categoryIds");		
		try {
			if (brandId == 0 || categoryIds == null || categoryIds.length == 0) {
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}
			for(String categoryIdStr: categoryIds){
				long categoryId = 0;
				try {
					categoryId = Long.parseLong(categoryIdStr.trim());
				} catch (Exception ignored) {
				}
				if(categoryId>0){
					brandCategoryCombinationService.deleteBrandCategoryCombination(brandId, categoryId);
				}
				LogUtil.log.info(WebUtil.getUserId(request) + " deletes BrandCategoryCombination brandId=" + brandId + ", categoryId=" + categoryId);
			}
		} catch (Exception e) {
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "Delete false!", response);
			e.printStackTrace();
		}
		return "redirect:/admin.do?action=manageBrandCategoryCombination&brandId="+brandId;
	}

}
