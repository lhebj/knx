package com.knx.dao;

import java.util.List;

import com.knx.pojo.Index;

public interface IIndexDAO {

	public void saveOrUpdateIndex(Index index);
	
	public Index findIndexById(Long id);
	
	public void deleteIndex(Index index);
	
	public List<Index> getRandomIndexList (int limit, String typeIdx); 
	
	public List<Index> getRandomIndexListByPosition (String positionIdx); 
}
