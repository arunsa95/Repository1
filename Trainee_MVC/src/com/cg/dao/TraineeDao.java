/**
 * 
 */
package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.cg.bean.Trainee;

/**
 * @author aruravic
 *
 */
@Transactional
@Repository
@EnableTransactionManagement
public class TraineeDao implements ITraineeDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Trainee addTrainee(Trainee trainee) {
		entityManager.persist(trainee);
		entityManager.flush();
		return trainee;
	}

	@Override
	public Trainee deleteTrainee(int traineeId) {
		Trainee dTrainee = entityManager.find(Trainee.class,
				traineeId);
		entityManager.remove(dTrainee);

		return dTrainee;
	}

	@Override
	public Trainee updateTrainee(Trainee trainee) {
		entityManager.merge(trainee);
		entityManager.flush();
		return trainee;
	}

	@Override
	public Trainee getTrainee(int traineeId) {
		Trainee getTrainee = entityManager.find(Trainee.class,
				traineeId);
		entityManager.remove(getTrainee);

		return getTrainee;
	}

	@Override
	public List<Trainee> getAllTrainee() {
		String sql = "SELECT tr FROM Trainee tr ";
		TypedQuery<Trainee> tQuery = entityManager.createQuery(sql,
				Trainee.class);
		List<Trainee> traineeList = tQuery.getResultList();

		return traineeList;
	}

}
