package com.knx.dao;

import java.util.List;

import com.knx.pojo.ProductDownload;

public interface IProductDownloadDAO {
	public void saveOrUpdateProductDownload(ProductDownload pdl);
	
	public ProductDownload findProductDownloadById(Long id);
	
	public void deleteProductDownload(ProductDownload pdl);
	
	public void deleteProductDownloadById(Long id);
	
	public List<ProductDownload> getProductDownloadListByProductId (Long productId);
}
