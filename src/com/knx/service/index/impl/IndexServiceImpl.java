package com.knx.service.index.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.knx.dao.IContentDAO;
import com.knx.dao.IIndexDAO;
import com.knx.pojo.Index;
import com.knx.service.index.IIndexService;

@Service(value = "indexService")
public class IndexServiceImpl implements IIndexService {
	
	@Resource
	private IContentDAO contentDAO;
	
	@Resource
	private IIndexDAO indexDAO;

	@Override
	public void saveOrUpdateIndex(Index index) {
		// TODO Auto-generated method stub
		indexDAO.saveOrUpdateIndex(index);
	}

	@Override
	public Index findIndexDetailById(Long id) {
		// TODO Auto-generated method stub
		return indexDAO.findIndexById(id);
	}

	@Override
	public void deleteIndex(Index index) {
		// TODO Auto-generated method stub
		indexDAO.deleteIndex(index);
	}

	@Override
	public List<Index> getRandomIndexList(int limit, String typeIdx) {
		// TODO Auto-generated method stub
		return indexDAO.getRandomIndexList(limit, typeIdx);
	}
	
	public List<Index> getRandomIndexListByPosition(String positionIdx){
		return indexDAO.getRandomIndexListByPosition(positionIdx);
	}

}
