package org.fiuba.aedesalarmengine.model.engine;

import org.fiuba.aedesalarmengine.model.disease.Disease;

public class AlarmResult {

	private boolean posibleDisease;

	private Disease disease;

	private int totalScoring;

	public AlarmResult(boolean posibleDisease, Disease disease, int totalScoring) {
		super();
		this.posibleDisease = posibleDisease;
		this.disease = disease;
		this.totalScoring = totalScoring;
	}

	public boolean isPosibleDisease() {
		return posibleDisease;
	}

	public Disease getDisease() {
		return disease;
	}

	public int getTotalScoring() {
		return totalScoring;
	}

}
