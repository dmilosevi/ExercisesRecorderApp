package com.app.exercisesrecorder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exercisesrecorder.exception.ExerciseNotFoundException;
import com.app.exercisesrecorder.model.Exercise;
import com.app.exercisesrecorder.repository.ExerciseRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ExerciseService {
	
	@Autowired
	private ExerciseRepository exerciseRepository;
	
	public Exercise addExercise(Exercise exercise) {
		return exerciseRepository.save(exercise);
	}
	
	public List<Exercise> findAllExercises(){
		return exerciseRepository.findAll();
	}
	
	public Exercise updateExercise(Exercise updatedExercise, Long id) {
		return exerciseRepository.findExerciseById(id)
				.map(existingExercise -> {
					existingExercise.setName(updatedExercise.getName());
					existingExercise.setBodyPart(updatedExercise.getBodyPart());
					existingExercise.setNumberOfSets(updatedExercise.getNumberOfSets());
					existingExercise.setNumberOfReps(updatedExercise.getNumberOfReps());
					existingExercise.setWeight(updatedExercise.getWeight());
					return exerciseRepository.save(existingExercise);
				}).orElseThrow(() -> new ExerciseNotFoundException("Vježba s id-em " + id + " nije pronađena"));
	}  
	
	public void deleteExercise(Long id) {
		if(!exerciseRepository.existsExerciseById(id)) {
			throw new ExerciseNotFoundException("Vježba s id-em " + id + " nije pronađena");
		}
		exerciseRepository.deleteExerciseById(id);
	}
	
	public Exercise findExerciseById(Long id) {
		return exerciseRepository.findExerciseById(id)
				.orElseThrow(() -> new ExerciseNotFoundException("Vježba s id-em " + id + " nije pronađena"));
				
	}
}
