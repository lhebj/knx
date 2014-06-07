package com.knx.dao.hibernate.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.knx.dao.IBasicHibernateDAO;
import com.knx.dao.IBrandDAO;
import com.knx.pojo.Brand;

@Repository("brandDAO")
public class BrandDAOImpl implements IBrandDAO {

	@Resource
	private IBasicHibernateDAO basicHibernateDao;

	@Override
	public void saveOrUpdateBrand(Brand brand) {
		// TODO Auto-generated method stub
		basicHibernateDao.saveOrUpdate(brand);
	}

	@Override
	public Brand findBrandById(Long id) {
		// TODO Auto-generated method stub
		return basicHibernateDao.getById(Brand.class, id);
	}

	@Override
	public void deleteBrand(Long id) {
		// TODO Auto-generated method stub
		String sql = " delete from pro_brand_brd where id_brd=:id_brd";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id_brd", id);
		basicHibernateDao.executeSql(sql, param);
	}

	@Override
	public List<Brand> getBrandList(int start, int limit) {
		// TODO Auto-generated method stub
		String hql = " from Brand where isEnabledBrd=true";
		return basicHibernateDao.getResultList(start, limit, hql);
	}
	
	public List<Brand> getBrandListOrderByName (){
		String hql = " from Brand where isEnabledBrd=true order by nameBrd";
		return basicHibernateDao.getResultList(hql, new HashMap<String, Object>());
	}

}
