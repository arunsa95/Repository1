/**
 * 
 */
package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bean.Trainee;
import com.cg.dao.ITraineeDao;

/**
 * @author aruravic
 *
 */
@Service
public class TraineeService implements ITraineeService {

	@Autowired
	ITraineeDao traineedao;

	public ITraineeDao getTraineedao() {
		return traineedao;
	}

	public void setTraineedao(ITraineeDao traineedao) {
		this.traineedao = traineedao;
	}

	@Override
	public Trainee addTrainee(Trainee trainee) {

		return traineedao.addTrainee(trainee);
	}

	@Override
	public Trainee deleteTrainee(int traineeId) {
		// TODO Auto-generated method stub
		return traineedao.deleteTrainee(traineeId);
	}

	@Override
	public Trainee updateTrainee(Trainee trainee) {
		// TODO Auto-generated method stub
		return traineedao.updateTrainee(trainee);
	}

	@Override
	public Trainee getTrainee(int traineeId) {
		// TODO Auto-generated method stub
		return traineedao.getTrainee(traineeId);
	}

	@Override
	public List<Trainee> getAllTrainee() {
		// TODO Auto-generated method stub
		return traineedao.getAllTrainee();
	}

}
