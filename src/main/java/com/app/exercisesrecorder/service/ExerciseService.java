package com.app.exercisesrecorder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exercisesrecorder.exception.ExerciseNotFoundException;
import com.app.exercisesrecorder.model.Exercise;
import com.app.exercisesrecorder.repository.ExerciseRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional //Dodan zbog "deleteExercise"
public class ExerciseService {

	/*@Autowired
	public ExerciseService(ExerciseRepository exerciseRepository) {
		super();
		this.exerciseRepository = exerciseRepository;
	}*/
	
	@Autowired
	private ExerciseRepository exerciseRepository;
	
	public Exercise addExercise(Exercise exercise) {
		return exerciseRepository.save(exercise);
	}
	
	public List<Exercise> findAllExercises(){
		return exerciseRepository.findAll();
	}
	
	public Exercise updateExercise(Exercise exercise) {
		return exerciseRepository.save(exercise);
	}  
	
	public void deleteExercise(Long id) {
		exerciseRepository.deleteExerciseById(id);;
	}
	
	public Exercise findExerciseById(Long id) {
		return exerciseRepository.findExerciseById(id)
				.orElseThrow(() -> new ExerciseNotFoundException("Exercise by id " + id + " was not found"));
				
	}
}
