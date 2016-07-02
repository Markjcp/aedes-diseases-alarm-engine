package org.fiuba.aedesalarmengine.model;

import java.util.List;

public class Case {

	private long id;

	private String name;

	private String surname;

	private String identification;

	private List<SymptomOccurrence> symptoms;

	private boolean livesInRiskyArea;

	private boolean visitedRiskyArea;

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

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getIdentification() {
		return identification;
	}

	public List<SymptomOccurrence> getSymptoms() {
		return symptoms;
	}

	public boolean isLivesInRiskyArea() {
		return livesInRiskyArea;
	}

	public boolean isVisitedRiskyArea() {
		return visitedRiskyArea;
	}

}
