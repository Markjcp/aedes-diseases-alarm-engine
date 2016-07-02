package org.fiuba.aedesalarmengine.model;

import java.util.List;
import java.util.Map;

public class ScoringConfiguration {
	
	private int totalScore;
	
	private List<SymptomsScoringConfiguration> symptomsScoring;
	
	private List<Disease> diseases;
	
	private Map<Disease,Integer> diseasesScoring;
	
	public void buildConfiguration(int totalScore, List<SymptomsScoringConfiguration> symptomsScoring, List<Disease> diseases, Map<Disease,Integer> diseasesScoring){
		this.totalScore = totalScore;
		this.symptomsScoring = symptomsScoring;
		this.diseases = diseases;
		this.diseasesScoring = diseasesScoring;
		int diseaseScore = 0;
//		for (SymptomsScoringConfiguration diseaseScoringConfiguration : diseasesScoring) {
//			diseaseScore += diseaseScoringConfiguration.computeScore();
//			if(diseaseScore>totalScore){
//				throw new ConfigurationException();
//			}
//		}
	}

	public int getTotalScore() {
		return totalScore;
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
	
	
	
	

}
