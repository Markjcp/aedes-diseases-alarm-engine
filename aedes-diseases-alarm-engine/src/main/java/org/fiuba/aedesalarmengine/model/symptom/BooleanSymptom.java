package org.fiuba.aedesalarmengine.model.symptom;

public class BooleanSymptom extends Symptom {

	private static final String SYMPTOM_NAME = "BOOLEAN_SYMPTOM";

	private String symptomName;
	
	public BooleanSymptom(){
		super();
	}

	public BooleanSymptom(Long id, String symptomName) {
		super(id, SYMPTOM_NAME);
		this.symptomName = symptomName;
	}

	public String getSymptomName() {
		return symptomName;
	}

}
