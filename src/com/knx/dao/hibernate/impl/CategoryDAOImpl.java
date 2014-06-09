package com.knx.dao.hibernate.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.knx.dao.IBasicHibernateDAO;
import com.knx.dao.ICategoryDAO;
import com.knx.pojo.Category;


@Repository("categoryDAO")
public class CategoryDAOImpl implements ICategoryDAO {
	

	@Resource
	private IBasicHibernateDAO basicHibernateDao;

	@Override
	public void saveOrUpdateCategory(Category category) {
		// TODO Auto-generated method stub
		basicHibernateDao.saveOrUpdate(category);
	}

	@Override
	public Category findCategoryById(Long id) {
		// TODO Auto-generated method stub
		return basicHibernateDao.getById(Category.class, id);
	}

	@Override
	public void deleteCategory(Long id) {
		// TODO Auto-generated method stub
		String sql = " delete from pro_category_cat where id_cat=:id_cat";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id_cat", id);
		basicHibernateDao.executeSql(sql, param);
	}
	
	public List<Category> getCategoryList (){
		String hql = " from Category where isEnabledCat=true";
		return basicHibernateDao.getResultList(hql, new HashMap<String, Object>());
	}

}
