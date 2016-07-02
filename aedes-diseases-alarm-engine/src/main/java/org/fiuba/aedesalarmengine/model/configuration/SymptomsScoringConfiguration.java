package org.fiuba.aedesalarmengine.model.configuration;

import java.util.Map;

import org.fiuba.aedesalarmengine.model.disease.Disease;
import org.fiuba.aedesalarmengine.model.symptom.Symptom;

public class SymptomsScoringConfiguration {

	private Symptom symptom;

	private Map<Disease, Integer> scoresByDisease;

	public SymptomsScoringConfiguration(Symptom symptom, Map<Disease, Integer> scoresByDisease) {
		super();
		this.symptom = symptom;
		this.scoresByDisease = scoresByDisease;
	}

	public Symptom getSymptom() {
		return symptom;
	}

	public Map<Disease, Integer> getScoresByDisease() {
		return scoresByDisease;
	}
}
