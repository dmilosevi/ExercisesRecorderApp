package com.app.exercisesrecorder.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.exercisesrecorder.model.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

	void deleteExerciseById(Long id);

	Optional<Exercise> findExerciseById(Long id);
	
	boolean existsExerciseById(Long id);

}
