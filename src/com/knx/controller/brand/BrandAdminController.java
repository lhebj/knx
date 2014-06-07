package com.knx.controller.brand;

import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.knx.pojo.Brand;
import com.knx.pojo.BrandDetail;
import com.knx.pojo.Content;
import com.knx.service.brand.IBrandService;
import com.knx.service.content.IContentService;
import com.knx.service.product.IProductService;
import com.knx.web.upload.UploadFileUtil;
import com.knx.web.util.BrandUtil;
import com.knx.web.util.CommonStaticConst;
import com.knx.web.util.JSONHelperUtil;
import com.knx.web.util.KnxConfig;
import com.knx.web.util.LocalizationUtil;
import com.knx.web.util.LogUtil;
import com.knx.web.util.ParamUtils;
import com.knx.web.util.StringUtil;
import com.knx.web.util.WebUtil;

@Controller
@RequestMapping("/brandAdmin.do")
public class BrandAdminController {

	
	@Resource(name = "brandService")
	private IBrandService brandService;
	
	
	@Resource(name = "productService")
	private IProductService productService;
	
	@Resource(name = "contentService")
	private IContentService contentService;
	
	@RequestMapping(params = "action=save")
	public String save(HttpServletRequest request, HttpServletResponse response) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		String nameBrd = ParamUtils.getParameter(request, "nameBrd");
		String introductionBrdd = ParamUtils.getParameter(request, "introductionBrdd");
		
		try {
			Map<String, Map<String, Object>> fileMap = UploadFileUtil.uploadMultiFile(request, Content.SRC_CON_BRAND, KnxConfig.MAX_UPLOADSIZE);
			Map<String, Object> logoMap = fileMap.get(BrandDetail.FILE_LOGO);
			boolean isSuccess = (Boolean) logoMap.get(UploadFileUtil.SUCCESS);
			if (id == 0 && !isSuccess) {
				return "redirect:/error.do?action=1&message=" +  (String) logoMap.get(UploadFileUtil.MESSAGE);
			}
			if (nameBrd == null) {
				return "redirect:/error.do?action=1&message=" +  (String) logoMap.get(UploadFileUtil.MESSAGE);
			}
			String initials = nameBrd.substring(0, 1);
			if(!Character.isLetter(initials.toCharArray()[0])){
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}
			
			Brand brand = null;
			BrandDetail brandDetail = null;
			if( id !=0 ){
				brand = brandService.findBrandById(id);
				brandDetail = brandService.findBrandDetailByBrand(brand);
			}
			if(brand == null){
				brand = new Brand();
				brandDetail = new BrandDetail();
			}
			brand.setNameBrd(nameBrd);
			brand.setInitialsBrd(initials.toUpperCase());
			brand.setIsEnabledBrd(true);
			brandService.saveOrUpdateBrand(brand);
			
			if (logoMap.get(UploadFileUtil.UPLOAD_FILE) != null) {
				Content content = (Content) logoMap.get(UploadFileUtil.UPLOAD_FILE);
				contentService.saveOrUpdateContent(content);
				brandDetail.setLogo(content);
			}
			brandDetail.setBrand(brand);
			brandDetail.setIntroductionBrdd(StringUtil.filterWordFormatAndSomeHTML(introductionBrdd));
			brandDetail.setIsEnabledBrdd(true);
			brandDetail.setDateCreateBrdd(new Date());
			
			
			brandService.saveOrUpdateBrandDetail(brandDetail);
	
			LogUtil.log.info(WebUtil.getUserId(request) + " saves brand id " + brand.getIdBrd());
			
			//update cache
			BrandUtil.updateBrandDTOListCache();
			
		} catch (Exception e) {
			e.printStackTrace();
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "saveOrUpdate false!", response);
		}
		return "redirect:/admin.do?action=manageBrand";
	}

	@RequestMapping(params = "action=delete")
	public String delete(HttpServletRequest request, HttpServletResponse response) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		
		try {
			if (id == 0) {
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}

			Map<String, Object> map = brandService.fullLogicallyDeleteBrandById(id, request);
			if((Boolean)map.get(CommonStaticConst.RETURN_SUCCESS) == false){
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}
			LogUtil.log.info(WebUtil.getUserId(request) + " deletes brand id " + id);
			//update cache
			BrandUtil.updateBrandDTOListCache();
		} catch (Exception e) {
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "Delete false!", response);
			e.printStackTrace();
		}
		return "redirect:/admin.do?action=manageBrand";
	}
}
