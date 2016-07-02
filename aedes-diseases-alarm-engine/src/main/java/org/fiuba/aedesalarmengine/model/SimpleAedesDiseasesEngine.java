package org.fiuba.aedesalarmengine.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleAedesDiseasesEngine {
	
	private ScoringConfiguration configuration;
	
	public SimpleAedesDiseasesEngine(ScoringConfiguration configuration) {
		super();
		this.configuration = configuration;
	}

	public AlarmResult runCase(Case caseToStudy){
		List<SymptomOccurrence> occurrences = caseToStudy.getSymptoms();
		List<SymptomsScoringConfiguration> configs = configuration.getSymptomsScoring();
		List<Disease> diseases = configuration.getDiseases();
		Map<Disease, Integer> calculations = new HashMap<Disease, Integer>();
		for (SymptomOccurrence symptomOccurrence : occurrences) {
			Symptom toFind = symptomOccurrence.getSymptom();
			SymptomsScoringConfiguration scoringConfiguration = findSymptom(toFind, configs);
			for (Disease disease : diseases) {
				Integer acum = scoringConfiguration.getScoresByDisease().get(disease);
				Integer aux = calculations.get(disease);
				if(aux!=null){
					acum = acum + aux;
				}
				calculations.put(disease,acum);
			}			
		}
		Map<Disease, Integer> scoringAlarm = configuration.getDiseasesScoring();
		List<Disease> resultDiseases = new ArrayList<Disease>();
		for (Disease disease : calculations.keySet()) {
			if(calculations.get(disease)>=scoringAlarm.get(disease)){
				resultDiseases.add(disease);
			}
		}
		boolean diseaseAlert = !resultDiseases.isEmpty() && (caseToStudy.isLivesInRiskyArea() || caseToStudy.isVisitedRiskyArea());
		Disease resultDisease = null;
		int totalScore = 0; 
		if(!resultDiseases.isEmpty()){
			resultDisease = resultDiseases.iterator().next();
			totalScore = calculations.get(resultDisease);
		}
		
		AlarmResult result = new AlarmResult(diseaseAlert, resultDisease, totalScore);
		return result;
	}
	
	private SymptomsScoringConfiguration findSymptom(Symptom symptom, List<SymptomsScoringConfiguration> configs){
		for (SymptomsScoringConfiguration symptomsScoringConfiguration : configs) {
			if(symptomsScoringConfiguration.getSymptom().getId() == symptom.getId()){
				return symptomsScoringConfiguration;
			}
		}
		return null;
		
	}

}
