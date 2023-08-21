package com.app.exercisesrecorder.model;


import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Exercise implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String name;
	private String numberOfSets;
	private String numberOfReps;
	private BigDecimal weight;
	private String bodyPart;
	
	public Exercise() {}
	
	public Exercise(String name, String numberOfSets, String numberOfReps, String bodyPart, BigDecimal weight) {
		super();
		this.name = name;
		this.numberOfSets = numberOfSets;
		this.numberOfReps = numberOfReps;
		this.weight = weight;
		this.bodyPart = bodyPart;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}


	public String getNumberOfSets() {
		return numberOfSets;
	}

	public void setNumberOfSets(String numberOfSets) {
		this.numberOfSets = numberOfSets;
	}


	public String getNumberOfReps() {
		return numberOfReps;
	}

	public void setNumberOfReps(String numberOfReps) {
		this.numberOfReps = numberOfReps;
	}


	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	
	public String getBodyPart() {
		return bodyPart;
	}

	public void setBodyPart(String bodyPart) {
		this.bodyPart = bodyPart;
	}

}
