package org.fiuba.aedesalarmengine.model.occurrences;

import org.fiuba.aedesalarmengine.model.exception.ValuationOccurrenceException;
import org.fiuba.aedesalarmengine.model.symptom.ValuatedSymptom;

public class ValuatedSymptomOccurrence extends SymptomOccurrence {

	private int valuation;
	
	public ValuatedSymptomOccurrence(){
		super();
	}

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
