package org.fiuba.aedesalarmengine.model;

public class ValuatedSymptomOccurrence extends SymptomOccurrence {

	private int valuation;

	public ValuatedSymptomOccurrence(ValuatedSymptom symptom, int valuation) {
		super(symptom);
		if(valuation > symptom.getMaxvaluation() || valuation< symptom.getMinvaluation()){
			throw new ValuationOccurrenceException();
		}
		this.valuation = valuation;
	}

	public int getValuation() {
		return valuation;
	}

}
