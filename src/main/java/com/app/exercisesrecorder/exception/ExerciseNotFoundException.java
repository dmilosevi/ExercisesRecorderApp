package com.app.exercisesrecorder.exception;

public class ExerciseNotFoundException extends RuntimeException{
	
	public ExerciseNotFoundException(String message) {
		super(message);
	}
}