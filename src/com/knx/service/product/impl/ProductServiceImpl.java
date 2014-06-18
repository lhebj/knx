package com.knx.service.product.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.knx.dao.IProductDAO;
import com.knx.dao.IProductDetailDAO;
import com.knx.dao.IProductDownloadDAO;
import com.knx.pojo.Content;
import com.knx.pojo.Product;
import com.knx.pojo.ProductDetail;
import com.knx.pojo.ProductDownload;
import com.knx.service.content.IContentService;
import com.knx.service.product.IProductService;
import com.knx.web.dto.ProductDTO;
import com.knx.web.util.CommonStaticConst;
import com.knx.web.util.LocalizationUtil;
import com.knx.web.util.LogUtil;
import com.knx.web.util.WebUtil;

@Service(value = "productService")
public class ProductServiceImpl implements IProductService {

	@Resource
	private IProductDAO productDAO;
	@Resource
	private IProductDetailDAO productDetailDAO;
	
	@Resource
	private IProductDownloadDAO productDownloadDAO;

	@Resource(name = "contentService")
	private IContentService contentService;

	@Override
	public void saveOrUpdateProduct(Product product) {
		// TODO Auto-generated method stub
		productDAO.saveOrUpdateProduct(product);
	}

	@Override
	public Product findProductById(Long id) {
		// TODO Auto-generated method stub
		return productDAO.findProductById(id);
	}

	@Override
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub
		productDAO.deleteProduct(product);
	}

	@Override
	public void deleteProductById(Long id) {
		// TODO Auto-generated method stub
		productDAO.deleteProductById(id);
	}

	public Map<String, Object> deleteFullProductById(Long id, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (id == 0) {
			map.put(CommonStaticConst.RETURN_MESSAGE, LocalizationUtil.getClientString("Parameter.error", request));
			map.put(CommonStaticConst.RETURN_SUCCESS, false);
			return map;
		}

		try {
			Product product = findProductById(id);
			ProductDetail pd = findProductDetailByProductId(id);
			if (product == null) {
				map.put(CommonStaticConst.RETURN_MESSAGE, LocalizationUtil.getClientString("Parameter.error", request));
				map.put(CommonStaticConst.RETURN_SUCCESS, false);
				return map;
			}

			if (pd == null) {
				map.put(CommonStaticConst.RETURN_MESSAGE, LocalizationUtil.getClientString("Parameter.error", request));
				map.put(CommonStaticConst.RETURN_SUCCESS, false);
				return map;
			}
			Content logo = product.getLogo();
			if (logo != null) {
				contentService.deleteContent(logo);
			}

			Content bigPic = pd.getIdbigpicPrdd();
			if (bigPic != null) {
				contentService.deleteContent(bigPic);
			}

			Content smallPic1 = pd.getIdsmallpic1Prdd();
			if (smallPic1 != null) {
				contentService.deleteContent(smallPic1);
			}

			Content smallPic2 = pd.getIdsmallpic2Prdd();
			if (smallPic2 != null) {
				contentService.deleteContent(smallPic2);
			}

			Content smallPic3 = pd.getIdsmallpic3Prdd();
			if (smallPic3 != null) {
				contentService.deleteContent(smallPic3);
			}

			Content smallPic4 = pd.getIdsmallpic4Prdd();
			if (smallPic4 != null) {
				contentService.deleteContent(smallPic4);
			}

			Content smallPic5 = pd.getIdsmallpic5Prdd();
			if (smallPic5 != null) {
				contentService.deleteContent(smallPic5);
			}

			Content smallPic6 = pd.getIdsmallpic6Prdd();
			if (smallPic6 != null) {
				contentService.deleteContent(smallPic6);
			}

			this.deleteProduct(product);
			this.deleteProductDetail(pd);
			LogUtil.log.info(WebUtil.getUserId(request) + " deletes product id " + id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put(CommonStaticConst.RETURN_MESSAGE, "");
		map.put(CommonStaticConst.RETURN_SUCCESS, true);
		return map;
	}

	@Override
	public List<ProductDTO> getProductDTOListByCategoryId(int start, int limit, long categoryId) {
		// TODO Auto-generated method stub
		List<ProductDTO> dtoList = new ArrayList<ProductDTO>();
		List<Product> list = productDAO.getProductListByCategoryId(start, limit, categoryId);
		for (Product product : list) {
			dtoList.add(product.toDTO());
		}
		return dtoList;
	}

	@Override
	public int getProductTotalCountByCategoryId(long categoryId) {
		return productDAO.getProductTotalCountByCategoryId(categoryId);
	}

	@Override
	public int getProductTotalCountByBrandId(long brandId) {
		return productDAO.getProductTotalCountByBrandId(brandId);
	}

	@Override
	public List<ProductDTO> getProductDTOListByBrandId(int start, int limit, long brandId) {
		// TODO Auto-generated method stub
		List<ProductDTO> dtoList = new ArrayList<ProductDTO>();
		List<Product> list = productDAO.getProductListByBrandId(start, limit, brandId);
		for (Product product : list) {
			dtoList.add(product.toDTO());
		}
		return dtoList;
	}

	public List<ProductDTO> getProductDTOListByBrandIdAndCategoryId(int start, int limit, long brandId, long categoryId) {
		// TODO Auto-generated method stub
		if(brandId == 0 && categoryId == 0){
			return this.getProductDTOList(start, limit);
		}
		if(brandId == 0 ){
			return this.getProductDTOListByCategoryId(start, limit, categoryId);
		}
		if(categoryId == 0){
			return this.getProductDTOListByBrandId(start, limit, brandId);
		}
		List<ProductDTO> dtoList = new ArrayList<ProductDTO>();
		List<Product> list = productDAO.getProductListByBrandIdAndCategoryId(start, limit, brandId, categoryId);
		for (Product product : list) {
			dtoList.add(product.toDTO());
		}
		return dtoList;
	}

	public int getProductTotalCountByBrandIdAndCategoryId(long brandId, long categoryId) {
		if(brandId == 0 && categoryId == 0){
			return this.getProductTotalCount();
		}
		if(brandId == 0 ){
			return this.getProductTotalCountByCategoryId(categoryId);
		}
		if(categoryId == 0){
			return this.getProductTotalCountByBrandId(brandId);
		}
		return productDAO.getProductTotalCountByBrandIdAndCategoryId(brandId, categoryId);
	}

	public List<ProductDTO> getProductDTOList(int start, int limit) {
		// TODO Auto-generated method stub
		List<ProductDTO> dtoList = new ArrayList<ProductDTO>();
		List<Product> list = productDAO.getProductList(start, limit);
		for (Product product : list) {
			dtoList.add(product.toDTO());
		}
		return dtoList;
	}

	public int getProductTotalCount() {
		return productDAO.getProductTotalCount();
	}

	@Override
	public int getProductTotalCountByName(String name) {
		return productDAO.getProductTotalCountByName(name);
	}

	@Override
	public List<ProductDTO> getProductListByModel(int start, int limit, String modelPrd) {
		List<ProductDTO> dtoList = new ArrayList<ProductDTO>();
		List<Product> list = productDAO.getProductListByModel(start, limit, modelPrd);
		for (Product product : list) {
			dtoList.add(product.toDTO());
		}
		return dtoList;
	}

	public void saveOrUpdateProductDetail(ProductDetail bd) {
		productDetailDAO.saveOrUpdateProductDetail(bd);
	}

	public ProductDetail findProductDetailByProductId(Long productId) {
		return productDetailDAO.findProductDetailByProductId(productId);
	}

	public void deleteProductDetail(ProductDetail bd) {
		productDetailDAO.deleteProductDetail(bd);
	}

	public List<ProductDetail> getProductDetailList(int start, int limit) {
		return productDetailDAO.getProductDetailList(start, limit);
	}
	
	public void saveOrUpdateProductDownload(ProductDownload pdl){
		productDownloadDAO.saveOrUpdateProductDownload(pdl);
	}
	
	public ProductDownload findProductDownloadById(Long id){
		return productDownloadDAO.findProductDownloadById(id);
	}
	
	public void deleteProductDownload(ProductDownload pdl){
		productDownloadDAO.deleteProductDownload(pdl);
	}
	
	public void deleteProductDownloadById(Long id){
		productDownloadDAO.deleteProductDownloadById(id);
	}
	
	public List<ProductDownload> getProductDownloadListByProductId (Long productId){
		return productDownloadDAO.getProductDownloadListByProductId(productId);
	}
}
