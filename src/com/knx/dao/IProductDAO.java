package com.knx.dao;

import java.util.List;

import com.knx.pojo.Product;

public interface IProductDAO {

	public void saveOrUpdateProduct(Product product);
	
	public Product findProductById(Long id);
	
	public void deleteProduct(Product product);
	
	public void deleteProductById(Long id);
	
	public List<Product> getProductListByCategoryId (int start, int limit, long categoryId);
	
	public int getProductTotalCountByCategoryId(long categoryId);
	
	public List<Product> getProductListByBrandId (int start, int limit, long brandId); 
	
	public int getProductTotalCountByBrandId(long brandId);
	
	public List<Product> getProductListByBrandIdAndCategoryId (int start, int limit, long brandId, long categoryId);
	
	public int getProductTotalCountByBrandIdAndCategoryId(long brandId, long categoryId) ;
	
	public List<Product> getProductList (int start, int limit);
	
	public int getProductTotalCount();
	
	public List<Product> getProductListByModel (int start, int limit, String modelPrd); 
	
	public int getProductTotalCountByName(String name); 
}
