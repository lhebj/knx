package com.knx.dao.hibernate.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.knx.dao.IBasicHibernateDAO;
import com.knx.dao.IBrandDetailDAO;
import com.knx.pojo.Brand;
import com.knx.pojo.BrandDetail;

@Repository("brandDetailDAO")
public class BrandDetailDAOImpl implements IBrandDetailDAO {

	@Resource
	private IBasicHibernateDAO basicHibernateDao;

	@Override
	public void saveOrUpdateBrandDetail(BrandDetail bd) {
		// TODO Auto-generated method stub
		basicHibernateDao.saveOrUpdate(bd);
	}

	@Override
	public BrandDetail findBrandDetailByBrand(Brand brand) {
		// TODO Auto-generated method stub
		String hql = " from BrandDetail where brand.idBrd=:idBrd";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("idBrd", brand.getIdBrd());
		List<BrandDetail> list = basicHibernateDao.getResultList(0, 1, hql.toString(), param);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public void deleteBrandDetail(BrandDetail bd) {
		// TODO Auto-generated method stub
		basicHibernateDao.delete(bd);
	}

	@Override
	public List<BrandDetail> getBrandDetailList(int start, int limit) {
		// TODO Auto-generated method stub
		String hql = " from BrandDetail where isEnabledBrdd=true";
		return basicHibernateDao.getResultList(start, limit, hql);
	}
}
