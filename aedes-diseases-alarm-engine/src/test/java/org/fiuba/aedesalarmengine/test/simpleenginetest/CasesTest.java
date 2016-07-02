package org.fiuba.aedesalarmengine.test.simpleenginetest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.fiuba.aedesalarmengine.model.BooleanSymptom;
import org.fiuba.aedesalarmengine.model.BooleanSymptomOccurrence;
import org.fiuba.aedesalarmengine.model.Case;
import org.fiuba.aedesalarmengine.model.Disease;
import org.fiuba.aedesalarmengine.model.ScoringConfiguration;
import org.fiuba.aedesalarmengine.model.SimpleAedesDiseasesEngine;
import org.fiuba.aedesalarmengine.model.Symptom;
import org.fiuba.aedesalarmengine.model.SymptomOccurrence;
import org.fiuba.aedesalarmengine.model.SymptomsScoringConfiguration;
import org.fiuba.aedesalarmengine.model.ValuatedSymptom;
import org.fiuba.aedesalarmengine.model.ValuatedSymptomOccurrence;
import org.junit.Before;
import org.junit.Test;

public class CasesTest {
	
	private SimpleAedesDiseasesEngine engine = null;
	
	@Before
	public void setup(){
		ScoringConfiguration configuration = new ScoringConfiguration();
		configuration.buildConfiguration(0, getDefaultSymptomsScoring(), getDefaultDiseases(), getDefaultDiseasesScoring());
		this.engine = new SimpleAedesDiseasesEngine(configuration);		
	}
	
	@Test
	public void shouldDetectAlarm(){
		List<SymptomOccurrence> occurrences = new ArrayList<SymptomOccurrence>();
		occurrences.add(new ValuatedSymptomOccurrence(new ValuatedSymptom(1l, "INCUBACION", 0, 4, 1), 2));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(2l, "FIEBRE")));
		
		Case caseToStudy = new Case(1l, "MARCOS", "FORLENZA", "33438259", occurrences, true, false);
		assertEquals(engine.runCase(caseToStudy).isPosibleDisease(),true);		
	}
	
	private Map<Disease, Integer> getDefaultDiseasesScoring(){
		Map<Disease,Integer> result = new HashMap<Disease,Integer>();
		result.put(new Disease(1l, "DENGUE"),40);
		result.put(new Disease(2l, "CHIKUNGUYA"),40);
		result.put(new Disease(3l, "ZIKA"),40);
		result.put(new Disease(4l, "FIEBRE AMARILLA"),40);
		return result;
	}
	
	private List<SymptomsScoringConfiguration> getDefaultSymptomsScoring(){
		List<SymptomsScoringConfiguration> result = new ArrayList<SymptomsScoringConfiguration>();
		
		Map<Disease,Integer> symptomConfig1Valuations = new HashMap<Disease,Integer>();		
		symptomConfig1Valuations.put(new Disease(1l, "DENGUE"),4);
		symptomConfig1Valuations.put(new Disease(2l, "CHIKUNGUYA"),5);
		symptomConfig1Valuations.put(new Disease(3l, "ZIKA"),3);
		symptomConfig1Valuations.put(new Disease(4l, "FIEBRE AMARILLA"),2);		
		SymptomsScoringConfiguration symptomConfig1 = new SymptomsScoringConfiguration(new ValuatedSymptom(1l, "INCUBACION", 0, 4, 1), symptomConfig1Valuations);
		result.add(symptomConfig1);
		
		Map<Disease,Integer> symptomConfig2Valuations = new HashMap<Disease,Integer>();		
		symptomConfig1Valuations.put(new Disease(1l, "DENGUE"),4);
		symptomConfig1Valuations.put(new Disease(2l, "CHIKUNGUYA"),5);
		symptomConfig1Valuations.put(new Disease(3l, "ZIKA"),4);
		symptomConfig1Valuations.put(new Disease(4l, "FIEBRE AMARILLA"),4);		
		SymptomsScoringConfiguration symptomConfig2 = new SymptomsScoringConfiguration(new BooleanSymptom(2l, "FIEBRE"), symptomConfig2Valuations);
		result.add(symptomConfig2);
		
		Map<Disease,Integer> symptomConfig3Valuations = new HashMap<Disease,Integer>();		
		symptomConfig1Valuations.put(new Disease(1l, "DENGUE"),4);
		symptomConfig1Valuations.put(new Disease(2l, "CHIKUNGUYA"),5);
		symptomConfig1Valuations.put(new Disease(3l, "ZIKA"),4);
		symptomConfig1Valuations.put(new Disease(4l, "FIEBRE AMARILLA"),4);		
		SymptomsScoringConfiguration symptomConfig3 = new SymptomsScoringConfiguration(new BooleanSymptom(3l, "MIALGIAS"), symptomConfig3Valuations);
		result.add(symptomConfig3);
		
		Map<Disease,Integer> symptomConfig4Valuations = new HashMap<Disease,Integer>();		
		symptomConfig1Valuations.put(new Disease(1l, "DENGUE"),4);
		symptomConfig1Valuations.put(new Disease(2l, "CHIKUNGUYA"),5);
		symptomConfig1Valuations.put(new Disease(3l, "ZIKA"),4);
		symptomConfig1Valuations.put(new Disease(4l, "FIEBRE AMARILLA"),3);		
		SymptomsScoringConfiguration symptomConfig4 = new SymptomsScoringConfiguration(new BooleanSymptom(4l, "ARTRALGIAS"), symptomConfig4Valuations);
		result.add(symptomConfig4);
		
		Map<Disease,Integer> symptomConfig5Valuations = new HashMap<Disease,Integer>();		
		symptomConfig1Valuations.put(new Disease(1l, "DENGUE"),4);
		symptomConfig1Valuations.put(new Disease(2l, "CHIKUNGUYA"),4);
		symptomConfig1Valuations.put(new Disease(3l, "ZIKA"),3);
		symptomConfig1Valuations.put(new Disease(4l, "FIEBRE AMARILLA"),2);		
		SymptomsScoringConfiguration symptomConfig5 = new SymptomsScoringConfiguration(new BooleanSymptom(5l, "CEFALEA"), symptomConfig5Valuations);
		result.add(symptomConfig5);
		
		Map<Disease,Integer> symptomConfig6Valuations = new HashMap<Disease,Integer>();		
		symptomConfig1Valuations.put(new Disease(1l, "DENGUE"),3);
		symptomConfig1Valuations.put(new Disease(2l, "CHIKUNGUYA"),4);
		symptomConfig1Valuations.put(new Disease(3l, "ZIKA"),5);
		symptomConfig1Valuations.put(new Disease(4l, "FIEBRE AMARILLA"),1);		
		SymptomsScoringConfiguration symptomConfig6 = new SymptomsScoringConfiguration(new BooleanSymptom(6l, "EXANTEMA"), symptomConfig6Valuations);
		result.add(symptomConfig6);
		
		Map<Disease,Integer> symptomConfig7Valuations = new HashMap<Disease,Integer>();		
		symptomConfig1Valuations.put(new Disease(1l, "DENGUE"),3);
		symptomConfig1Valuations.put(new Disease(2l, "CHIKUNGUYA"),3);
		symptomConfig1Valuations.put(new Disease(3l, "ZIKA"),3);
		symptomConfig1Valuations.put(new Disease(4l, "FIEBRE AMARILLA"),2);		
		SymptomsScoringConfiguration symptomConfig7 = new SymptomsScoringConfiguration(new BooleanSymptom(7l, "DIARREA Y VOMITOS"), symptomConfig7Valuations);
		result.add(symptomConfig7);
		
		
		
		
		
		return result;
	}
	
	
	private List<Symptom> getDefaultSymptom(){
		List<Symptom> result = new ArrayList<Symptom>();
		result.add(new ValuatedSymptom(1l, "INCUBACION", 0, 4, 1));
		result.add(new BooleanSymptom(2l, "FIEBRE"));
		result.add(new BooleanSymptom(3l, "MIALGIAS"));
		result.add(new BooleanSymptom(4l, "ARTRALGIAS"));
		result.add(new BooleanSymptom(5l, "CEFALEA"));
		result.add(new BooleanSymptom(6l, "EXANTEMA"));
		result.add(new BooleanSymptom(7l, "DIARREA Y VOMITOS"));
		result.add(new BooleanSymptom(8l, "SHOCK"));
		result.add(new BooleanSymptom(9l, "ICTERICIA"));
		result.add(new BooleanSymptom(10l,"LEUCOPENIA"));
		result.add(new BooleanSymptom(11l, "NEUTROPENIA"));
		result.add(new BooleanSymptom(12l, "LINFOPEMIA"));
		result.add(new BooleanSymptom(13l, "TROMBOCIPENIA"));
		result.add(new ValuatedSymptom(14l, "DURACION ENFERMEDAD", 0, 4, 1));
		return result;
	}
	
	private List<Disease> getDefaultDiseases(){
		List<Disease> result = new ArrayList<Disease>();
		result.add(new Disease(1l, "DENGUE"));
		result.add(new Disease(2l, "CHIKUNGUYA"));
		result.add(new Disease(3l, "ZIKA"));
		result.add(new Disease(4l, "FIEBRE AMARILLA"));
		return result;
	}

}
