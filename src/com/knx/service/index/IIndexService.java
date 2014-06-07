package com.knx.service.index;

import java.util.List;

import com.knx.pojo.Index;

public interface IIndexService {

	public void saveOrUpdateIndex(Index index);
	
	public Index findIndexDetailById(Long id);
	
	public void deleteIndex(Index index);
	
	public List<Index> getRandomIndexList (int limit, String typeIdx); 
	
	public List<Index> getRandomIndexListByPosition(String positionIdx);
}
