package org.fiuba.aedesalarmengine.model.occurrences;

import org.fiuba.aedesalarmengine.model.symptom.Symptom;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = As.PROPERTY, property = "@class")
@JsonSubTypes({ @Type(value = ValuatedSymptomOccurrence.class, name = "ValuatedSymptomOccurrence"),
		@Type(value = BooleanSymptomOccurrence.class, name = "BooleanSymptomOccurrence") })
public abstract class SymptomOccurrence {

	private Symptom symptom;
	
	public SymptomOccurrence(){
		super();
	}

	public SymptomOccurrence(Symptom symptom) {
		super();
		this.symptom = symptom;
	}

	public Symptom getSymptom() {
		return symptom;
	}
}
