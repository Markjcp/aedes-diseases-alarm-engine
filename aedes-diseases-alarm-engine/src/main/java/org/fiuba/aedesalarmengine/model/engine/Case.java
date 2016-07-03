package org.fiuba.aedesalarmengine.model.engine;

import java.util.List;

import org.fiuba.aedesalarmengine.model.occurrences.SymptomOccurrence;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

@JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS, include = As.PROPERTY, property = "@class")
public class Case {

	private long id;

	private String name;

	private String surname;

	private String identification;

	private List<SymptomOccurrence> symptoms;

	private boolean livesInRiskyArea;

	private boolean visitedRiskyArea;
	
	public Case(){
		super();
	}

	public Case(long id, String name, String surname, String identification, List<SymptomOccurrence> symptoms,
			boolean livesInRiskyArea, boolean visitedRiskyArea) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.identification = identification;
		this.symptoms = symptoms;
		this.livesInRiskyArea = livesInRiskyArea;
		this.visitedRiskyArea = visitedRiskyArea;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public List<SymptomOccurrence> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(List<SymptomOccurrence> symptoms) {
		this.symptoms = symptoms;
	}

	public boolean isLivesInRiskyArea() {
		return livesInRiskyArea;
	}

	public void setLivesInRiskyArea(boolean livesInRiskyArea) {
		this.livesInRiskyArea = livesInRiskyArea;
	}

	public boolean isVisitedRiskyArea() {
		return visitedRiskyArea;
	}

	public void setVisitedRiskyArea(boolean visitedRiskyArea) {
		this.visitedRiskyArea = visitedRiskyArea;
	}
}
