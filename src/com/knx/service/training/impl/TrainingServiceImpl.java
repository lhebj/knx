package com.knx.service.training.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.knx.dao.ITrainingDAO;
import com.knx.pojo.Training;
import com.knx.service.training.ITrainingService;

@Service(value = "trainingService")
public class TrainingServiceImpl implements ITrainingService {

	@Resource
	private ITrainingDAO trainingDAO;
	
	@Override
	public void saveOrUpdateTraining(Training training) {
		// TODO Auto-generated method stub
		trainingDAO.saveOrUpdateTraining(training);
	}

	@Override
	public Training findTrainingById(Long id) {
		// TODO Auto-generated method stub
		return trainingDAO.findTrainingById(id);
	}

	@Override
	public void deleteTraining(Training training) {
		// TODO Auto-generated method stub
		trainingDAO.deleteTraining(training);
	}
		
	@Override
	public void deleteTrainingById(Long id){
		trainingDAO.deleteTrainingById(id);
	}

	@Override
	public List<Training> getTrainingList(int start, int limit) {
		// TODO Auto-generated method stub
		return trainingDAO.getTrainingList(start, limit);
	}

	@Override
	public int getTrainingTotalCount(){
		return trainingDAO.getTrainingTotalCount();
	}
}
