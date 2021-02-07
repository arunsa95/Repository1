/**
 * 
 */
package com.cg.dao;

import java.util.List;

import com.cg.bean.Trainee;

/**
 * @author aruravic
 *
 */
public interface ITraineeDao {
	
	
	
	public Trainee addTrainee(Trainee trainee);

	public Trainee deleteTrainee(int traineeId);

	public Trainee updateTrainee(Trainee trainee);

	public Trainee getTrainee(int traineeId);
	
	public List<Trainee> getAllTrainee();
}
