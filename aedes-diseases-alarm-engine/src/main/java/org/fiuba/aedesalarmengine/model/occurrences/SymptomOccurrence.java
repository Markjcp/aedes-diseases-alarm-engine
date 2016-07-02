package org.fiuba.aedesalarmengine.model.occurrences;

import org.fiuba.aedesalarmengine.model.symptom.Symptom;

public abstract class SymptomOccurrence {
	
	private Symptom symptom;

	public SymptomOccurrence(Symptom symptom) {
		super();
		this.symptom = symptom;
	}

	public Symptom getSymptom() {
		return symptom;
	}
}
