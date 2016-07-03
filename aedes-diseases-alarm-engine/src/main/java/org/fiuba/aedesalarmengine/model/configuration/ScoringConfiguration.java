package org.fiuba.aedesalarmengine.model.configuration;

import java.util.List;
import java.util.Map;

import org.fiuba.aedesalarmengine.model.disease.Disease;

public class ScoringConfiguration {
	
	private List<SymptomsScoringConfiguration> symptomsScoring;
	
	private List<Disease> diseases;
	
	private Map<Disease,Integer> diseasesScoring;
	
	private int occurrencesRoundsQuantity;
	
	public void buildConfiguration( List<SymptomsScoringConfiguration> symptomsScoring, List<Disease> diseases, Map<Disease,Integer> diseasesScoring, int occurrencesRoundsQuantity){
		this.symptomsScoring = symptomsScoring;
		this.diseases = diseases;
		this.diseasesScoring = diseasesScoring;
		this.occurrencesRoundsQuantity = occurrencesRoundsQuantity;
	}

	public List<SymptomsScoringConfiguration> getSymptomsScoring() {
		return symptomsScoring;
	}

	public List<Disease> getDiseases() {
		return diseases;
	}

	public Map<Disease, Integer> getDiseasesScoring() {
		return diseasesScoring;
	}

	public int getOccurrencesRoundsQuantity() {
		return occurrencesRoundsQuantity;
	}
}
