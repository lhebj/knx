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
import com.knx.pojo.Category;
import com.knx.pojo.Content;
import com.knx.pojo.Product;
import com.knx.pojo.ProductDetail;
import com.knx.pojo.ProductDownload;
import com.knx.service.brand.IBrandService;
import com.knx.service.category.ICategoryService;
import com.knx.service.content.IContentService;
import com.knx.service.product.IProductService;
import com.knx.web.upload.UploadFileUtil;
import com.knx.web.util.CommonStaticConst;
import com.knx.web.util.JSONHelperUtil;
import com.knx.web.util.KnxConfig;
import com.knx.web.util.LocalizationUtil;
import com.knx.web.util.LogUtil;
import com.knx.web.util.ParamUtils;
import com.knx.web.util.StringUtil;
import com.knx.web.util.WebUtil;

@Controller
@RequestMapping("/productAdmin.do")
public class ProductAdminController {

	@Resource(name = "brandService")
	private IBrandService brandService;

	@Resource(name = "categoryService")
	private ICategoryService categoryService;

	@Resource(name = "productService")
	private IProductService productService;

	@Resource(name = "contentService")
	private IContentService contentService;

	@RequestMapping(params = "action=save")
	public String save(HttpServletRequest request, HttpServletResponse response) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		Long idbrdPrd = ParamUtils.getLongParameter(request, "idbrdPrd", 0);
		Long idcatPrd = ParamUtils.getLongParameter(request, "idcatPrd", 0);
		String namePrd = ParamUtils.getParameter(request, "namePrd");
		String modelPrd = ParamUtils.getParameter(request, "modelPrd");
		String placePrdd = ParamUtils.getParameter(request, "placePrdd");
		String parametersPrdd = ParamUtils.getParameter(request, "parametersPrdd");
		String featuresPrdd = ParamUtils.getParameter(request, "featuresPrdd");
		String supplierPrdd = ParamUtils.getParameter(request, "supplierPrdd");
		String introductionPrdd = ParamUtils.getParameter(request, "introductionPrdd");

		try {
			Map<String, Map<String, Object>> fileMap = UploadFileUtil.uploadMultiFile(request, Content.SRC_CON_PRODUCT, KnxConfig.MAX_UPLOADSIZE);

			Map<String, Object> logoMap = fileMap.get(Product.FILE_LOGO);
			boolean isSuccess = (Boolean) logoMap.get(UploadFileUtil.SUCCESS);
			if (id == 0 && !isSuccess) {
				return "redirect:/error.do?action=1&message=" + (String) logoMap.get(UploadFileUtil.MESSAGE);
			}
			Map<String, Object> bigPicMap = fileMap.get(ProductDetail.FILE_BIG_PIC);
			isSuccess = (Boolean) bigPicMap.get(UploadFileUtil.SUCCESS);
			if (id == 0 && !isSuccess) {
				return "redirect:/error.do?action=1&message=" + (String) bigPicMap.get(UploadFileUtil.MESSAGE);
			}

			Map<String, Object> smallPic1Map = fileMap.get(ProductDetail.FILE_SMALL_PIC_1);
			// isSuccess = (Boolean) smallPic1Map.get(UploadFileUtil.SUCCESS);
			// if (id == 0 && !isSuccess) {
			// return "redirect:/error.do?action=1&message=" + (String)
			// smallPic1Map.get(UploadFileUtil.MESSAGE);
			// }

			Map<String, Object> smallPic2Map = fileMap.get(ProductDetail.FILE_SMALL_PIC_2);
			// isSuccess = (Boolean) smallPic2Map.get(UploadFileUtil.SUCCESS);
			// if (id == 0 && !isSuccess) {
			// return "redirect:/error.do?action=1&message=" + (String)
			// smallPic2Map.get(UploadFileUtil.MESSAGE);
			// }

			Map<String, Object> smallPic3Map = fileMap.get(ProductDetail.FILE_SMALL_PIC_3);
			// isSuccess = (Boolean) smallPic3Map.get(UploadFileUtil.SUCCESS);
			// if (id == 0 && !isSuccess) {
			// return "redirect:/error.do?action=1&message=" + (String)
			// smallPic3Map.get(UploadFileUtil.MESSAGE);
			// }

			Map<String, Object> smallPic4Map = fileMap.get(ProductDetail.FILE_SMALL_PIC_4);
			// isSuccess = (Boolean) smallPic4Map.get(UploadFileUtil.SUCCESS);
			// if (id == 0 && !isSuccess) {
			// return "redirect:/error.do?action=1&message=" + (String)
			// smallPic4Map.get(UploadFileUtil.MESSAGE);
			// }

			Map<String, Object> smallPic5Map = fileMap.get(ProductDetail.FILE_SMALL_PIC_5);
			// isSuccess = (Boolean) smallPic5Map.get(UploadFileUtil.SUCCESS);
			// if (id == 0 && !isSuccess) {
			// return "redirect:/error.do?action=1&message=" + (String)
			// smallPic5Map.get(UploadFileUtil.MESSAGE);
			// }

			Map<String, Object> smallPic6Map = fileMap.get(ProductDetail.FILE_SMALL_PIC_6);
			// isSuccess = (Boolean) smallPic6Map.get(UploadFileUtil.SUCCESS);
			// if (id == 0 && !isSuccess) {
			// return "redirect:/error.do?action=1&message=" + (String)
			// smallPic6Map.get(UploadFileUtil.MESSAGE);
			// }
			
			Map<String, Object> detailLogoMap = fileMap.get(ProductDetail.FILE_DETAIL_LOGO);

			Brand brand = null;
			if (idbrdPrd != 0) {
				brand = brandService.findBrandById(idbrdPrd);
			}
			if (brand == null) {
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}

			Category category = null;
			if (idcatPrd != 0) {
				category = categoryService.findCategoryById(idcatPrd);
			}
			if (category == null) {
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}

			Product product = null;
			ProductDetail pd = null;
			if (id != 0) {
				product = productService.findProductById(id);
				pd = productService.findProductDetailByProductId(id);
			}

			if (product == null) {
				product = new Product();
				pd = new ProductDetail();
			}
			product.setBrand(brand);
			product.setCategory(category);
			product.setNamePrd(namePrd);
			product.setModelPrd(modelPrd);

			if (logoMap.get(UploadFileUtil.UPLOAD_FILE) != null) {
				Content content = (Content) logoMap.get(UploadFileUtil.UPLOAD_FILE);
				contentService.saveOrUpdateContent(content);
				product.setLogo(content);
			}

			pd.setPlacePrdd(placePrdd);
			pd.setFeaturesPrdd(StringUtil.filterWordFormatAndSomeHTML(featuresPrdd));
			pd.setIntroductionPrdd(StringUtil.filterWordFormatAndSomeHTML(introductionPrdd));
			pd.setSupplierPrdd(StringUtil.filterWordFormatAndSomeHTML(supplierPrdd));
			pd.setParametersPrdd(StringUtil.filterWordFormatAndSomeHTML(parametersPrdd));
			pd.setDateCreatePrdd(new Date());

			if (bigPicMap.get(UploadFileUtil.UPLOAD_FILE) != null) {
				Content content = (Content) bigPicMap.get(UploadFileUtil.UPLOAD_FILE);
				contentService.saveOrUpdateContent(content);
				pd.setIdbigpicPrdd(content);
			}

			if (smallPic1Map.get(UploadFileUtil.UPLOAD_FILE) != null) {
				Content content = (Content) smallPic1Map.get(UploadFileUtil.UPLOAD_FILE);
				contentService.saveOrUpdateContent(content);
				pd.setIdsmallpic1Prdd(content);
			}

			if (smallPic2Map.get(UploadFileUtil.UPLOAD_FILE) != null) {
				Content content = (Content) smallPic2Map.get(UploadFileUtil.UPLOAD_FILE);
				contentService.saveOrUpdateContent(content);
				pd.setIdsmallpic2Prdd(content);
			}

			if (smallPic3Map.get(UploadFileUtil.UPLOAD_FILE) != null) {
				Content content = (Content) smallPic3Map.get(UploadFileUtil.UPLOAD_FILE);
				contentService.saveOrUpdateContent(content);
				pd.setIdsmallpic3Prdd(content);
			}

			if (smallPic4Map.get(UploadFileUtil.UPLOAD_FILE) != null) {
				Content content = (Content) smallPic4Map.get(UploadFileUtil.UPLOAD_FILE);
				contentService.saveOrUpdateContent(content);
				pd.setIdsmallpic4Prdd(content);
			}

			if (smallPic5Map.get(UploadFileUtil.UPLOAD_FILE) != null) {
				Content content = (Content) smallPic5Map.get(UploadFileUtil.UPLOAD_FILE);
				contentService.saveOrUpdateContent(content);
				pd.setIdsmallpic5Prdd(content);
			}

			if (smallPic6Map.get(UploadFileUtil.UPLOAD_FILE) != null) {
				Content content = (Content) smallPic6Map.get(UploadFileUtil.UPLOAD_FILE);
				contentService.saveOrUpdateContent(content);
				pd.setIdsmallpic6Prdd(content);
			}
			
			if (detailLogoMap.get(UploadFileUtil.UPLOAD_FILE) != null) {
				Content content = (Content) detailLogoMap.get(UploadFileUtil.UPLOAD_FILE);
				contentService.saveOrUpdateContent(content);
				pd.setIddetaillogoPrdd(content);
			}


			productService.saveOrUpdateProduct(product);
			pd.setProduct(product);
			productService.saveOrUpdateProductDetail(pd);

			this.processUploadFiles(request, product, fileMap);

			LogUtil.log.info(WebUtil.getUserId(request) + " saves product id " + brand.getIdBrd());

		} catch (Exception e) {
			e.printStackTrace();
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "saveOrUpdate false!", response);
		}
		return "redirect:/admin.do?action=manageProduct&categoryId=" + idcatPrd + "&brandId=" + idbrdPrd;
	}

	private void processUploadFiles(HttpServletRequest request, Product product, Map<String, Map<String, Object>> fileMap) {
		Map<String, Object> uploadFileMap = null;
		for (int i = 1; i <= ProductDownload.MAX_UPLOADFILES; i++) {
//			String nameprdlKey = "namePrdl" + i;
			String namePrdl = ParamUtils.getParameter(request, (ProductDownload.NAME_PRE + i));
			if (namePrdl == null) {
//				LogUtil.log.info(WebUtil.getUserId(request) + " saves ProductDownload, productId= " + product.getIdPrd() + ", namePrdl is null, break!");
				continue;
			}
//			String filePrdlKey = ProductDownload.FILE_PRE + i;
			uploadFileMap = fileMap.get(ProductDownload.FILE_PRE + i);
			if (!(Boolean) uploadFileMap.get(UploadFileUtil.SUCCESS) || uploadFileMap.get(UploadFileUtil.UPLOAD_FILE) == null) {
//				LogUtil.log.info(WebUtil.getUserId(request) + " saves ProductDownload, productId= " + product.getIdPrd() + ", UPLOAD_FILE is null, break!");
				continue;
			}
			
			Content filePrdl = (Content) uploadFileMap.get(UploadFileUtil.UPLOAD_FILE);
			contentService.saveOrUpdateContent(filePrdl);
			
			ProductDownload pdl = new ProductDownload();
			pdl.setProduct(product);
			pdl.setFilePrdl(filePrdl);
			pdl.setNamePrdl(namePrdl);
			pdl.setDateCreatePrdl(new Date());
			productService.saveOrUpdateProductDownload(pdl);
			LogUtil.log.info(WebUtil.getUserId(request) + " saves ProductDownload, productId= " + product.getIdPrd() + ", namePrdl = " + namePrdl);
		}
		
		//delete old files
		String deleteOldFilesId = ParamUtils.getParameter(request, "deleteOldFiles");
		if(deleteOldFilesId != null){
			String[] deleteOldFilesIdArray = deleteOldFilesId.split(",");
			for(int i=0;i<deleteOldFilesIdArray.length;i++){
				if(StringUtil.isNumeric(deleteOldFilesIdArray[i])){
					productService.deleteProductDownloadById(Long.parseLong(deleteOldFilesIdArray[i]));
					LogUtil.log.info(WebUtil.getUserId(request) + " delete ProductDownload, productId= " + product.getIdPrd() + ", id = " + deleteOldFilesIdArray[i]);
				}
			}
		}

	}

	@RequestMapping(params = "action=delete")
	public String delete(HttpServletRequest request, HttpServletResponse response) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		Long categoryId = ParamUtils.getLongParameter(request, "categoryId", 0);

		try {
			if (id == 0) {
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}
			Map<String, Object> map = productService.deleteFullProductById(id, request);
			if ((Boolean) map.get(CommonStaticConst.RETURN_SUCCESS) == false) {
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}

		} catch (Exception e) {
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "Delete false!", response);
			e.printStackTrace();
		}
		return "redirect:/admin.do?action=manageProduct&categoryId=" + categoryId;
	}
}
