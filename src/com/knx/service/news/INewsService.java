package com.knx.service.news;

import java.util.List;

import com.knx.pojo.News;

public interface INewsService {

	public void saveOrUpdateNews(News news);
	
	public News findNewsById(Long id);
	
	public void deleteNews(News news);
	
	public void deleteNewsById(Long id);
	
	public List<News> getNewsList (int start, int limit); 
	
	public int getNewsTotalCount();
}
