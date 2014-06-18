package com.knx.controller.brand;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.knx.pojo.Content;
import com.knx.pojo.ProductDetail;
import com.knx.pojo.ProductDownload;
import com.knx.service.brand.IBrandService;
import com.knx.service.product.IProductService;
import com.knx.web.dto.ProductDTO;
import com.knx.web.dto.ProductDetailDTO;
import com.knx.web.dto.ProductDownloadDTO;
import com.knx.web.upload.UploadFileUtil;
import com.knx.web.util.FileUtil;
import com.knx.web.util.LocalizationUtil;
import com.knx.web.util.PageUtil;
import com.knx.web.util.ParamUtils;
import com.knx.web.util.StringUtil;
import com.knx.web.util.WebUtil;

@Controller
@RequestMapping("/product.do")
public class ProductController {

	@Resource(name = "brandService")
	private IBrandService brandService;

	@Resource(name = "productService")
	private IProductService productService;

	@RequestMapping(params = "action=detail")
	public String detail(HttpServletRequest request, HttpServletResponse response, Model model) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		if (id == 0) {
			return "redirect:/error.do?action=1&message=" + LocalizationUtil.getClientString("PageNotFound", request);
		}

		ProductDetail productDetail = productService.findProductDetailByProductId(id);
		if (productDetail == null) {
			return "redirect:/error.do?action=1&message=" + LocalizationUtil.getClientString("PageNotFound", request);
		}
		ProductDetailDTO dto = productDetail.toDTO();
		model.addAttribute("productDetailDTO", dto);

		List<ProductDownload> list = productService.getProductDownloadListByProductId(id);
		List<ProductDownloadDTO> pdownloadDTOList = new ArrayList<ProductDownloadDTO>();
		for (ProductDownload pd : list) {
			pdownloadDTOList.add(pd.toDTO());
		}
		model.addAttribute("pdownloadDTOList", pdownloadDTOList);
		// SEO
		String seoDescription = StringUtil.html2Text(productDetail.getIntroductionPrdd());
		seoDescription = seoDescription.trim().replaceAll("[\\t\\n\\r]", "").replaceAll("&nbsp;", "").replaceAll("\\s*", "");
		model.addAttribute("seoDescription", seoDescription.trim());
		
		String seoKey = StringUtil.html2Text(dto.getBrandDTO().getNameBrd() + "," + dto.getCategoryDTO().getNameCat() + "," + dto.getProductDTO().getModelPrd() + "," + dto.getSupplierPrdd());
		seoKey = seoKey.trim().replaceAll("[\\t\\n\\r]", "").replaceAll("&nbsp;", "").replaceAll("\\s*", "");
		model.addAttribute("seoKey", seoKey.trim());
		
		
		return "product";
	}

	@RequestMapping(params = "action=list")
	public String list(HttpServletRequest request, HttpServletResponse response, Model model) {
		String wd = ParamUtils.getParameter(request, "wd");
		int curPage = ParamUtils.getIntParameter(request, "curPage", 1);
		int pageSize = ParamUtils.getIntParameter(request, "pageSize", 8);

		if (wd == null) {
			return "redirect:/error.do?action=1&message=" + LocalizationUtil.getClientString("PageNotFound", request);
		}
		int totalCount = productService.getProductTotalCountByName(wd);
		PageUtil pageUtil = new PageUtil(totalCount, curPage, pageSize);
		;
		List<ProductDTO> productDTOList = productService.getProductListByModel(pageUtil.getStart(), pageUtil.getEnd(), wd);

		model.addAttribute("wd", wd);
		model.addAttribute("productDTOList", productDTOList);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageutil", pageUtil.getToolBar("product.do?action=list&wd=" + wd, request));

		return "productList";
	}
	
	@RequestMapping(params = "action=download")
	public String download(HttpServletRequest request, HttpServletResponse response, Model model) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		if (id == 0) {
			try {
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("PageNotFound", request), "utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (WebUtil.isGuest()) {
			try {
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("NeedLogin", request), "utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ProductDownload pd = productService.findProductDownloadById(id);
		if (pd == null) {
			try {
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("PageNotFound", request), "utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

		Content content = pd.getFilePrdl();
		if (content == null) {
			try {
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("PageNotFound", request), "utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		OutputStream out = null;
		try{
			
			String fileName = content.getOriginalFilenameCon();			
			String userAgent = request.getHeader("User-Agent");
			if (userAgent != null && userAgent.toUpperCase().indexOf("MSIE") > 0) {
				fileName = URLEncoder.encode(fileName, "UTF-8");
			} else {
				fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
			}

			response.reset();
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
			response.setHeader("Connection", "close");
			response.setContentLength(content.getFilesizeCon().intValue());
			out = response.getOutputStream();
			if (content.getFilepathCon() != null) {
				String filePath = UploadFileUtil.getContentAbsolutePath(request, content);
				FileUtil.load(filePath, out);
			}
			
			response.setStatus(HttpServletResponse.SC_OK);
			
		}catch(Exception e){
			 e.printStackTrace();
		}finally{
			try {
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				response.flushBuffer();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
			
		return null;
	}
}
