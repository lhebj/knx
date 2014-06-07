package com.knx.dao.hibernate.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.knx.dao.IBasicHibernateDAO;
import com.knx.dao.ITrainingDAO;
import com.knx.pojo.Training;

@Repository("trainingDAO")
public class TrainingDAOImpl implements ITrainingDAO {


	@Resource
	private IBasicHibernateDAO basicHibernateDao;

	@Override
	public void saveOrUpdateTraining(Training training) {
		// TODO Auto-generated method stub
		basicHibernateDao.saveOrUpdate(training);
	}

	@Override
	public Training findTrainingById(Long id) {
		// TODO Auto-generated method stub
		return basicHibernateDao.getById(Training.class, id);
	}

	@Override
	public void deleteTraining(Training training) {
		// TODO Auto-generated method stub
		basicHibernateDao.delete(training);
	}
	
	@Override
	public void deleteTrainingById(Long id){
		String sql = " delete from pro_training_tra where id_tra=:id_tra";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id_tra", id);
		basicHibernateDao.executeSql(sql, param);
	}

	@Override
	public List<Training> getTrainingList(int start, int limit) {
		// TODO Auto-generated method stub
		String hql = " from Training order by idTra desc ";
		return basicHibernateDao.getResultList(start, limit, hql);
	}
	
	@Override
	public int getTrainingTotalCount(){
		String hql = " from Training";
		return basicHibernateDao.getTotalCount(hql);
	}

}
