package com.knx.controller.brand;

import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.knx.pojo.Brand;
import com.knx.pojo.BrandDetail;
import com.knx.service.brand.IBrandService;
import com.knx.service.brandcategorycombination.IBrandCategoryCombinationService;
import com.knx.service.product.IProductService;
import com.knx.web.dto.BrandDTO;
import com.knx.web.dto.ProductDTO;
import com.knx.web.util.BrandUtil;
import com.knx.web.util.JSONHelperUtil;
import com.knx.web.util.LocalizationUtil;
import com.knx.web.util.PageUtil;
import com.knx.web.util.ParamUtils;

@Controller
@RequestMapping("/brand.do")
public class BrandController {	
	

	@Resource(name = "brandService")
	private IBrandService brandService;
	
	@Resource(name = "productService")
	private IProductService productService; 
	
	@Resource(name = "brandCategoryCombinationService")
	private IBrandCategoryCombinationService brandCategoryCombinationService;
	
	
	@RequestMapping(params = "action=detail")
	public String detail(HttpServletRequest request, HttpServletResponse response, Model model) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		try{
			if(id==0){
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("PageNotFound", request), "utf-8");
			}
			
			Brand brand = brandService.findBrandById(id);
			if(brand == null){
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("PageNotFound", request), "utf-8");
			}
			
			BrandDetail brandDetail = brandService.findBrandDetailByBrand(brand);		
			if(brandDetail == null){
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("PageNotFound", request), "utf-8");
			}
			model.addAttribute("brandDetailDTO", brandDetail.toDTO());		
			
			//左侧导航品牌	
			model.addAttribute("brandDTOList",  brandService.getBrandDTOListOrderByName());	
			
			//分类及产品
			int curPage = ParamUtils.getIntParameter(request, "curPage", 1);
			int pageSize = ParamUtils.getIntParameter(request, "pageSize", 8);
			Long categoryId = ParamUtils.getLongParameter(request, "categoryId", 0);
			int totalCount = 0;
			List<ProductDTO> productDTOList = null;
			PageUtil pageUtil = null;
			String pageLink = null;
			
			if(categoryId != 0) {
				totalCount = productService.getProductTotalCountByBrandIdAndCategoryId(id, categoryId);
				pageUtil = new PageUtil(totalCount, curPage, pageSize);
				productDTOList = productService.getProductDTOListByBrandIdAndCategoryId(pageUtil.getStart(), pageUtil.getEnd(), id, categoryId);
				pageLink = "brand.do?action=detail&id="+id + "&categoryId="+categoryId;
			}else {
				totalCount = productService.getProductTotalCountByBrandId(id);
				pageUtil = new PageUtil(totalCount, curPage, pageSize);
				productDTOList = productService.getProductDTOListByBrandId(pageUtil.getStart(), pageUtil.getEnd(), id);
				pageLink = "brand.do?action=detail&id="+id;
			}
			
			model.addAttribute("productDTOList", productDTOList);
			model.addAttribute("totalCount", totalCount);
			model.addAttribute("pageutil", pageUtil.getToolBar(pageLink, request));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "brandDetail";
	}
	
	@RequestMapping(params = "action=list")
	public String list (HttpServletRequest request, HttpServletResponse response, Model model) {
		Long categoryId = ParamUtils.getLongParameter(request, "categoryId", 0);
		try{
			Map<String, List<BrandDTO>> brandDTOMap = BrandUtil.getBrandTree();
			if(categoryId > 0){
				//get by categoryId
				List<BrandDTO> dtoList = brandCategoryCombinationService.getBrandListByCategoryId(categoryId);
				for(String key: brandDTOMap.keySet()){
					for(BrandDTO dto: brandDTOMap.get(key)){
						dto.setShow(false);
						for(BrandDTO showDto: dtoList){
							if(dto.getIdBrd().longValue()==showDto.getIdBrd().longValue()){
								dto.setShow(true);
							}
						}
						
					}
				}
			}			
			JSONHelperUtil.outputDTOToJSON(brandDTOMap, response);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}
