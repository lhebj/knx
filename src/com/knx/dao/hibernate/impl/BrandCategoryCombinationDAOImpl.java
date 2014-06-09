package com.knx.dao.hibernate.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.knx.dao.IBasicHibernateDAO;
import com.knx.dao.IBrandCategoryCombinationDAO;
import com.knx.pojo.BrandCategoryCombination;
@Repository("brandCategoryCombinationDAO")
public class BrandCategoryCombinationDAOImpl implements IBrandCategoryCombinationDAO {

	@Resource
	private IBasicHibernateDAO basicHibernateDao;

	@Override
	public void saveOrUpdateBrandCategoryCombination(BrandCategoryCombination brandCategoryCombination) {
		// TODO Auto-generated method stub
		basicHibernateDao.saveOrUpdate(brandCategoryCombination);
	}

	@Override
	public BrandCategoryCombination findBrandCategoryCombinationById(Long id) {
		// TODO Auto-generated method stub
		return basicHibernateDao.getById(BrandCategoryCombination.class, id);
	}
	
	@Override
	public BrandCategoryCombination findBrandCategoryCombination(Long brandId, Long categoryId){
		String hql = " from BrandCategoryCombination where brand.idBrd=:idBrd and category.idCat=:idCat";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("idBrd", brandId);
		param.put("idCat", categoryId);
		List<BrandCategoryCombination> list = basicHibernateDao.getResultList(0, 1, hql.toString(), param);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public void deleteBrandCategoryCombination(Long id) {
		// TODO Auto-generated method stub
		String sql = " delete from knx_brand_category_bc where id_bc=:id_bc";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id_bc", id);
		basicHibernateDao.executeSql(sql, param);
	}
	
	@Override
	public void deleteBrandCategoryCombination(Long brandId, Long categoryId){
		String sql = " delete from knx_brand_category_bc where id_brd_bc=:brandId and id_cat_bc=:categoryId";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("brandId", brandId);
		param.put("categoryId", categoryId);
		basicHibernateDao.executeSql(sql, param);
	}

	@Override
	public List<BrandCategoryCombination> getCategoryListByBrandId(Long brandId) {
		// TODO Auto-generated method stub
		String hql = " from BrandCategoryCombination bcc where brand.idBrd=:idBrd ";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("idBrd", brandId);
		return basicHibernateDao.getResultList(0, 0, hql, param);
	}

	@Override
	public List<BrandCategoryCombination> getBrandListByCategoryId(Long categoryId) {
		// TODO Auto-generated method stub
		String hql = " from BrandCategoryCombination where category.idCat=:idCat ";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("idCat", categoryId);
		return basicHibernateDao.getResultList(0, 0, hql, param);
	}

}
