package com.knx.service.product;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.knx.pojo.Product;
import com.knx.pojo.ProductDetail;
import com.knx.pojo.ProductDownload;
import com.knx.web.dto.ProductDTO;

public interface IProductService {

public void saveOrUpdateProduct(Product product);
	
	public Product findProductById(Long id);
	
	public void deleteProduct(Product product);
	
	public void deleteProductById(Long id);
	
	public  Map<String, Object> deleteFullProductById(Long id,HttpServletRequest request);
	
	public List<ProductDTO> getProductDTOListByCategoryId (int start, int limit, long categoryId);
	
	public int getProductTotalCountByCategoryId(long categoryId);
	
	public int getProductTotalCountByBrandId(long brandId);
	
	public List<ProductDTO> getProductDTOListByBrandId (int start, int limit, long brandId); 
	
	public List<ProductDTO> getProductDTOListByBrandIdAndCategoryId (int start, int limit, long brandId, long categoryId); 
	
	public int getProductTotalCountByBrandIdAndCategoryId(long brandId, long categoryId);
	
	public List<ProductDTO> getProductDTOList (int start, int limit);
	
	public int getProductTotalCount();
	
	public int getProductTotalCountByName(String name);
	
	public List<ProductDTO> getProductListByModel (int start, int limit, String modelPrd); 
	
	
	public void saveOrUpdateProductDetail(ProductDetail bd);
	
	public ProductDetail findProductDetailByProductId(Long productId);
	
	public void deleteProductDetail(ProductDetail bd);
	
	public List<ProductDetail> getProductDetailList (int start, int limit);
	
	
	public void saveOrUpdateProductDownload(ProductDownload pdl);
	
	public ProductDownload findProductDownloadById(Long id);
	
	public void deleteProductDownload(ProductDownload pdl);
	
	public void deleteProductDownloadById(Long id);
	
	public List<ProductDownload> getProductDownloadListByProductId (Long productId);
}
