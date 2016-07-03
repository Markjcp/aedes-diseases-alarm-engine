package org.fiuba.aedesalarmengine.model.engine;

import org.fiuba.aedesalarmengine.model.disease.Disease;

public class AlarmResult {

	private boolean posibleDisease;

	private Disease disease;

	private int totalScoring;

	private Case caseToEvaluate;
	
	public AlarmResult(Case caseToEvaluate){
		this.totalScoring = 0;
		this.posibleDisease = false;
		this.caseToEvaluate = caseToEvaluate;
	}	

	public AlarmResult(Disease disease, Case caseToEvaluate, int totalScoring) {
		super();
		this.disease = disease;
		this.caseToEvaluate = caseToEvaluate;
		this.totalScoring = totalScoring;
	}

	public boolean isPosibleDisease() {
		return posibleDisease;
	}

	public void setPosibleDisease(boolean posibleDisease) {
		this.posibleDisease = posibleDisease;
	}

	public Disease getDisease() {
		return disease;
	}

	public void setDisease(Disease disease) {
		this.disease = disease;
	}

	public int getTotalScoring() {
		return totalScoring;
	}

	public void setTotalScoring(int totalScoring) {
		this.totalScoring = totalScoring;
	}

	public Case getCaseToEvaluate() {
		return caseToEvaluate;
	}

	public void setCaseToEvaluate(Case caseToEvaluate) {
		this.caseToEvaluate = caseToEvaluate;
	}

}
