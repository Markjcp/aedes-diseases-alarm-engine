package org.fiuba.aedesalarmengine.model.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.fiuba.aedesalarmengine.model.configuration.ScoringConfiguration;
import org.fiuba.aedesalarmengine.model.configuration.SymptomsScoringConfiguration;
import org.fiuba.aedesalarmengine.model.disease.Disease;
import org.fiuba.aedesalarmengine.model.exception.ConfigurationException;
import org.fiuba.aedesalarmengine.model.occurrences.SymptomOccurrence;
import org.fiuba.aedesalarmengine.model.symptom.Symptom;

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
		List<Disease> resultDiseases = new ArrayList<Disease>();
		Map<Disease, Integer> scoringAlarm = configuration.getDiseasesScoring();
		Map<Disease, Integer> calculations = new HashMap<Disease, Integer>();
		List<List<SymptomOccurrence>> classifiedOccurrences = orderOccurrences(occurrences, configuration.getOccurrencesRoundsQuantity());
		
		for (List<SymptomOccurrence> occurrenceGroup : classifiedOccurrences) {
			evaluateOccurrences(occurrenceGroup, configs, diseases, calculations);
			
			computeTotals(resultDiseases, scoringAlarm, calculations);
			
			int totalScore = 0;
			Disease resultDisease = diagnoseDisease(resultDiseases, calculations);
			if(resultDisease != null){
				totalScore = calculations.get(resultDisease);			
				boolean diseaseAlert = evaluateLocation(caseToStudy, resultDiseases);
				AlarmResult result = new AlarmResult(diseaseAlert, resultDisease, totalScore);
				return result;
			}			
		}
		AlarmResult result = new AlarmResult(false, null, 0);
		return result;
	}

	private List<List<SymptomOccurrence>> orderOccurrences(List<SymptomOccurrence> occurrences,
			int occurrencesRoundsQuantity) {
		List<List<SymptomOccurrence>> result = new ArrayList<List<SymptomOccurrence>>();
		for(int i=0; i<occurrencesRoundsQuantity; i++){
			result.add(new ArrayList<SymptomOccurrence>());
		}
		for (SymptomOccurrence symptomOccurrence : occurrences) {
			if(symptomOccurrence.getSymptom().getOrder()+1>occurrencesRoundsQuantity){
				throw new ConfigurationException("Symptom order wrong configuration");
			}
			List<SymptomOccurrence> aux = result.get(symptomOccurrence.getSymptom().getOrder());
			aux.add(symptomOccurrence);
			result.set(symptomOccurrence.getSymptom().getOrder(), aux);
		}
		return result;
	}

	private Disease diagnoseDisease(List<Disease> resultDiseases, Map<Disease, Integer> calculations) {
		Disease resultDisease = null;
		if(!resultDiseases.isEmpty()){
			resultDisease = retrieveMaxDisease(resultDiseases, calculations);
		}
		return resultDisease;
	}

	private boolean evaluateLocation(Case caseToStudy, List<Disease> resultDiseases) {
		return !resultDiseases.isEmpty() && (caseToStudy.isLivesInRiskyArea() || caseToStudy.isVisitedRiskyArea());
	}

	private void computeTotals(List<Disease> resultDiseases, Map<Disease, Integer> scoringAlarm,
			Map<Disease, Integer> calculations) {
		for (Disease disease : calculations.keySet()) {
			if(calculations.get(disease)>=scoringAlarm.get(disease)){
				resultDiseases.add(disease);
			}
		}
	}

	private void evaluateOccurrences(List<SymptomOccurrence> occurrences, List<SymptomsScoringConfiguration> configs,
			List<Disease> diseases, Map<Disease, Integer> calculations) {
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
	}
	
	private SymptomsScoringConfiguration findSymptom(Symptom symptom, List<SymptomsScoringConfiguration> configs){
		for (SymptomsScoringConfiguration symptomsScoringConfiguration : configs) {
			if(symptomsScoringConfiguration.getSymptom().getId() == symptom.getId()){
				return symptomsScoringConfiguration;
			}
		}
		return null;
		
	}
	
	private Disease retrieveMaxDisease(List<Disease> diseases, Map<Disease, Integer> calculations){
		int max = 0;
		Disease maxDisease = null;
		for (Disease disease : diseases) {
			if(calculations.get(disease)>=max){
				max = calculations.get(disease);
				maxDisease = disease;
			}
		}
		return maxDisease;
	}

}
