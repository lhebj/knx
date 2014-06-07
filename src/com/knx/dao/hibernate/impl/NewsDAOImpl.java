package com.knx.dao.hibernate.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.knx.dao.IBasicHibernateDAO;
import com.knx.dao.INewsDAO;
import com.knx.pojo.News;

@Repository("newsDAO")
public class NewsDAOImpl implements INewsDAO {

	@Resource
	private IBasicHibernateDAO basicHibernateDao;

	@Override
	public void saveOrUpdateNews(News news) {
		// TODO Auto-generated method stub
		basicHibernateDao.saveOrUpdate(news);
	}

	@Override
	public News findNewsById(Long id) {
		// TODO Auto-generated method stub
		return basicHibernateDao.getById(News.class, id);
	}

	@Override
	public void deleteNews(News news) {
		// TODO Auto-generated method stub
		basicHibernateDao.delete(news);
	}
	
	@Override
	public void deleteNewsById(Long id){
		String sql = " delete from pro_news_n where id_n=:id_n";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id_n", id);
		basicHibernateDao.executeSql(sql, param);
	}

	@Override
	public List<News> getNewsList(int start, int limit) {
		// TODO Auto-generated method stub
		String hql = " from News order by idN desc ";
		return basicHibernateDao.getResultList(start, limit, hql);
	}
	
	@Override
	public int getNewsTotalCount(){
		String hql = " from News";
		return basicHibernateDao.getTotalCount(hql);
	}

}
