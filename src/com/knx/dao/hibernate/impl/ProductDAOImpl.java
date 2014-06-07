package com.knx.dao.hibernate.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.knx.dao.IBasicHibernateDAO;
import com.knx.dao.IProductDAO;
import com.knx.pojo.Product;

@Repository("productDAO")
public class ProductDAOImpl implements IProductDAO {

	@Resource
	private IBasicHibernateDAO basicHibernateDao;

	@Override
	public void saveOrUpdateProduct(Product product) {
		// TODO Auto-generated method stub
		basicHibernateDao.saveOrUpdate(product);
	}

	@Override
	public Product findProductById(Long id) {
		// TODO Auto-generated method stub
		return basicHibernateDao.getById(Product.class, id);
	}

	@Override
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub
		basicHibernateDao.delete(product);
	}

	@Override
	public void deleteProductById(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Product> getProductListByCategoryId(int start, int limit, long categoryId) {
		// TODO Auto-generated method stub
		String hql = " from Product where category.idCat=:idCat ";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("idCat", categoryId);
		return basicHibernateDao.getResultList(start, limit, hql, param);
	}

	@Override
	public int getProductTotalCountByCategoryId(long categoryId) {
		String hql = " from Product where category.idCat=:idCat ";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("idCat", categoryId);
		return basicHibernateDao.getTotalCount(hql, param);
	}

	@Override
	public List<Product> getProductListByBrandId(int start, int limit, long brandId) {
		// TODO Auto-generated method stub
		String hql = " from Product where brand.idBrd=:idBrd ";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("idBrd", brandId);
		return basicHibernateDao.getResultList(start, limit, hql, param);
	}

	@Override
	public int getProductTotalCountByBrandId(long brandId) {
		String hql = " from Product where brand.idBrd=:idBrd ";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("idBrd", brandId);
		return basicHibernateDao.getTotalCount(hql, param);
	}

	@Override
	public List<Product> getProductListByBrandIdAndCategoryId(int start, int limit, long brandId, long categoryId) {
		// TODO Auto-generated method stub
		String hql = " from Product where brand.idBrd=:idBrd and category.idCat=:idCat ";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("idBrd", brandId);
		param.put("idCat", categoryId);
		return basicHibernateDao.getResultList(start, limit, hql, param);
	}

	@Override
	public int getProductTotalCountByBrandIdAndCategoryId(long brandId, long categoryId) {
		String hql = " from Product where brand.idBrd=:idBrd and category.idCat=:idCat ";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("idBrd", brandId);
		param.put("idCat", categoryId);
		return basicHibernateDao.getTotalCount(hql, param);
	}

	@Override
	public List<Product> getProductList(int start, int limit) {
		String hql = " from Product";
		return basicHibernateDao.getResultList(start, limit, hql);
	}

	@Override
	public int getProductTotalCount() {
		String hql = " from Product";
		return basicHibernateDao.getTotalCount(hql);
	}

	@Override
	public List<Product> getProductListByName(int start, int limit, String name) {
		// TODO Auto-generated method stub
		String hql = " from Product where namePrd like :namePrd ";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("namePrd", "%" + name + "%");
		return basicHibernateDao.getResultList(start, limit, hql, param);
	}

	@Override
	public int getProductTotalCountByName(String name) {
		String hql = " from Product where namePrd like :namePrd ";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("namePrd", "%" + name + "%");
		return basicHibernateDao.getTotalCount(hql, param);
	}

}
