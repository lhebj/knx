package com.knx.service.news.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.knx.dao.INewsDAO;
import com.knx.pojo.News;
import com.knx.service.news.INewsService;

@Service(value = "newsService")
public class NewsServiceImpl implements INewsService {

	@Resource
	private INewsDAO newsDAO;
	
	@Override
	public void saveOrUpdateNews(News news) {
		// TODO Auto-generated method stub
		newsDAO.saveOrUpdateNews(news);
	}

	@Override
	public News findNewsById(Long id) {
		// TODO Auto-generated method stub
		return newsDAO.findNewsById(id);
	}

	@Override
	public void deleteNews(News news) {
		// TODO Auto-generated method stub
		newsDAO.deleteNews(news);
	}
		
	@Override
	public void deleteNewsById(Long id){
		newsDAO.deleteNewsById(id);
	}

	@Override
	public List<News> getNewsList(int start, int limit) {
		// TODO Auto-generated method stub
		return newsDAO.getNewsList(start, limit);
	}

	@Override
	public int getNewsTotalCount(){
		return newsDAO.getNewsTotalCount();
	}
}
