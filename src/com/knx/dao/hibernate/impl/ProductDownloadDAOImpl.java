package com.knx.dao.hibernate.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.knx.dao.IBasicHibernateDAO;
import com.knx.dao.IProductDownloadDAO;
import com.knx.pojo.ProductDownload;

@Repository("productDownloadDAO")
public class ProductDownloadDAOImpl implements IProductDownloadDAO {

	@Resource
	private IBasicHibernateDAO basicHibernateDao;

	@Override
	public void saveOrUpdateProductDownload(ProductDownload pdl) {
		// TODO Auto-generated method stub
		basicHibernateDao.saveOrUpdate(pdl);
	}

	@Override
	public ProductDownload findProductDownloadById(Long id) {
		// TODO Auto-generated method stub
		String hql = " from ProductDownload where idPrdl=:idPrdl ";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("idPrdl", id);
		List<ProductDownload> list = basicHibernateDao.getResultList(0, 1, hql.toString(), param);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public void deleteProductDownload(ProductDownload pdl) {
		// TODO Auto-generated method stub
		basicHibernateDao.delete(pdl);
	}
	
	public void deleteProductDownloadById(Long id){
		String hql = " delete from ProductDownload where idPrdl=:idPrdl ";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("idPrdl", id);
		basicHibernateDao.executeUpdate(hql, param);
	}

	@Override
	public List<ProductDownload> getProductDownloadListByProductId(Long productId) {
		// TODO Auto-generated method stub
		String hql = " from ProductDownload where product.idPrd=:idPrd ";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("idPrd", productId);
		List<ProductDownload> list = basicHibernateDao.getResultList(0, 0, hql.toString(), param);
		return list;
	}

}
