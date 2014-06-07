package com.knx.dao;

import java.util.List;

import com.knx.pojo.News;

public interface INewsDAO {

	public void saveOrUpdateNews(News news);
	
	public News findNewsById(Long id);
	
	public void deleteNews(News news);
	
	public void deleteNewsById(Long id);
	
	public List<News> getNewsList (int start, int limit); 
	
	public int getNewsTotalCount();
}
