package org.fiuba.aedesalarmengine.model.occurrences;

import org.fiuba.aedesalarmengine.model.symptom.BooleanSymptom;

public class BooleanSymptomOccurrence extends SymptomOccurrence {
	
	public BooleanSymptomOccurrence(){
		super();
	}
	
	public BooleanSymptomOccurrence(BooleanSymptom symptom){
		super(symptom);
	}
}