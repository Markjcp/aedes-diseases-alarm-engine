package org.fiuba.aedesalarmengine.model.symptom;

public class ValuatedSymptom extends Symptom {

	private static final String SYMPTOM_NAME = "VALUATED_SYMPTOM";

	private String valuatedSymptomName;

	private int minvaluation;

	private int maxvaluation;

	private int step;
	
	public ValuatedSymptom(){
		super();
	}

	public ValuatedSymptom(long id, String valuatedSymptomName, int minvaluation, int maxvaluation, int step, int order) {
		super(id, SYMPTOM_NAME,order);
		this.valuatedSymptomName = valuatedSymptomName;
		this.minvaluation = minvaluation;
		this.maxvaluation = maxvaluation;
		this.step = step;
	}

	public String getValuatedSymptomName() {
		return valuatedSymptomName;
	}

	public int getMinvaluation() {
		return minvaluation;
	}

	public int getMaxvaluation() {
		return maxvaluation;
	}

	public int getStep() {
		return step;
	}

}
