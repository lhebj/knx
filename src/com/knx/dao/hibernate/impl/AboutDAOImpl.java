package com.knx.dao.hibernate.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.knx.dao.IAboutDAO;
import com.knx.dao.IBasicHibernateDAO;
import com.knx.pojo.About;


@Repository("aboutDAO")
public class AboutDAOImpl implements IAboutDAO {

	@Resource
	private IBasicHibernateDAO basicHibernateDao;
	
	@Override
	public void saveOrUpdateAbout(About about) {
		// TODO Auto-generated method stub
		basicHibernateDao.saveOrUpdate(about);
	}

	@Override
	public About findAboutById(Long id) {
		// TODO Auto-generated method stub
		return basicHibernateDao.getById(About.class, id);
	}

	@Override
	public void deleteAbout(About about) {
		// TODO Auto-generated method stub
		basicHibernateDao.delete(about);
	}

	@Override
	public About findAboutByType(String typeAb) {
		// TODO Auto-generated method stub
		String hql = " from About where typeAb=:typeAb ";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("typeAb", typeAb);
		List<About> list = basicHibernateDao.getResultList(0, 1, hql.toString(), param);
		return list.size() > 0 ? list.get(0) : null;
	}

}
