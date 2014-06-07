package com.knx.service.training;

import java.util.List;

import com.knx.pojo.Training;

public interface ITrainingService {

	public void saveOrUpdateTraining(Training training);
	
	public Training findTrainingById(Long id);
	
	public void deleteTraining(Training training);
	
	public void deleteTrainingById(Long id);
	
	public List<Training> getTrainingList (int start, int limit); 
	
	public int getTrainingTotalCount();
}
