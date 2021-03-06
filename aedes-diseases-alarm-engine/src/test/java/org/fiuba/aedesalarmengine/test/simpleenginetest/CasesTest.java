package org.fiuba.aedesalarmengine.test.simpleenginetest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.fiuba.aedesalarmengine.model.configuration.ScoringConfiguration;
import org.fiuba.aedesalarmengine.model.configuration.SymptomsScoringConfiguration;
import org.fiuba.aedesalarmengine.model.disease.Disease;
import org.fiuba.aedesalarmengine.model.engine.AlarmResult;
import org.fiuba.aedesalarmengine.model.engine.Case;
import org.fiuba.aedesalarmengine.model.engine.SimpleAedesDiseasesEngine;
import org.fiuba.aedesalarmengine.model.occurrences.BooleanSymptomOccurrence;
import org.fiuba.aedesalarmengine.model.occurrences.SymptomOccurrence;
import org.fiuba.aedesalarmengine.model.occurrences.ValuatedSymptomOccurrence;
import org.fiuba.aedesalarmengine.model.symptom.BooleanSymptom;
import org.fiuba.aedesalarmengine.model.symptom.Symptom;
import org.fiuba.aedesalarmengine.model.symptom.ValuatedSymptom;
import org.junit.Before;
import org.junit.Test;

public class CasesTest {
	
	private SimpleAedesDiseasesEngine engine = null;
	
	private Logger logger = Logger.getLogger(CasesTest.class.toString());
	
	@Before
	public void setup(){
		ScoringConfiguration configuration = new ScoringConfiguration();
		configuration.buildConfiguration(getDefaultSymptomsScoring(), getDefaultDiseases(), getDefaultDiseasesScoring(),2);
		this.engine = new SimpleAedesDiseasesEngine(configuration);		
	}
	
	@Test
	public void shouldDetectAlarm(){
		List<SymptomOccurrence> occurrences = new ArrayList<SymptomOccurrence>();
		occurrences.add(new ValuatedSymptomOccurrence(new ValuatedSymptom(1l, "INCUBACION", 0, 4, 1,1), 2));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(2l, "FIEBRE",0)));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(4l, "ARTRALGIAS",0)));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(5l, "CEFALEA",0)));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(11l,"LEUCOPENIA",1)));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(13l, "LINFOPEMIA",1)));
		
		Case caseToStudy = new Case(1l, "MARCOS", "FORLENZA", "33438259", occurrences, true, false);
		AlarmResult alarmResult = engine.runCase(caseToStudy);
		logger.info("shouldDetectAlarm Final score: " + alarmResult.getTotalScoring() );
		assertEquals(alarmResult.isPosibleDisease(),true);
		assertEquals(alarmResult.getDisease().getId(),2l);
	}
	
	@Test
	public void shouldNotDetectAlarmByLocations(){
		List<SymptomOccurrence> occurrences = new ArrayList<SymptomOccurrence>();
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(5l, "CEFALEA",0)));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(11l,"LEUCOPENIA",1)));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(13l, "LINFOPEMIA",1)));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(12l, "NEUTROPENIA",1)));
		
		
		Case caseToStudy = new Case(1l, "MARCOS", "FORLENZA", "33438259", occurrences, false, false);
		AlarmResult alarmResult = engine.runCase(caseToStudy);
		logger.info("shouldNotDetectAlarmByLocations Final score: " + alarmResult.getTotalScoring() );
		assertEquals(alarmResult.isPosibleDisease(),false);		
	}
	
	@Test
	public void shouldNotDetectAlarmByScoring(){
		List<SymptomOccurrence> occurrences = new ArrayList<SymptomOccurrence>();
		occurrences.add(new ValuatedSymptomOccurrence(new ValuatedSymptom(1l, "INCUBACION", 0, 4, 1,1), 2));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(2l, "FIEBRE",0)));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(4l, "ARTRALGIAS",0)));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(5l, "CEFALEA",0)));
		
		Case caseToStudy = new Case(1l, "MARCOS", "FORLENZA", "33438259", occurrences, true, true);
		AlarmResult alarmResult = engine.runCase(caseToStudy);
		logger.info("shouldNotDetectAlarmByScoring Final score: " + alarmResult.getTotalScoring() );
		assertEquals(alarmResult.isPosibleDisease(),false);		
	}
	
	@Test
	public void shouldDetectDengueAlarm(){
		List<SymptomOccurrence> occurrences = new ArrayList<SymptomOccurrence>();
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(3l, "MIALGIAS",0)));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(5l, "CEFALEA",0)));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(6l, "EXANTEMA",0)));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(7l, "DIARREA Y VOMITOS",1)));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(8l, "HEMORRAGIAS",1)));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(9l, "SHOCK",1)));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(10l, "ICTERICIA",1)));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(11l,"LEUCOPENIA",1)));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(13l, "LINFOPEMIA",1)));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(14l, "TROMBOCIPENIA",1)));
		Case caseToStudy = new Case(1l, "MARCOS", "FORLENZA", "33438259", occurrences, true, false);
		AlarmResult alarmResult = engine.runCase(caseToStudy);
		logger.info("shouldDetectDengueAlarm Final score: " + alarmResult.getTotalScoring() );
		assertEquals(alarmResult.isPosibleDisease(),true);
		assertEquals(alarmResult.getDisease().getId(),1l);
	}
	
	@Test
	public void shouldNotDetectDengueAlarmByLocation(){
		List<SymptomOccurrence> occurrences = new ArrayList<SymptomOccurrence>();
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(2l, "FIEBRE",0)));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(3l, "MIALGIAS",0)));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(4l, "ARTRALGIAS",0)));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(5l, "CEFALEA",0)));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(6l, "EXANTEMA",0)));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(7l, "DIARREA Y VOMITOS",1)));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(8l, "HEMORRAGIAS",1)));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(9l, "SHOCK",1)));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(10l, "ICTERICIA",1)));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(11l,"LEUCOPENIA",1)));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(13l, "LINFOPEMIA",1)));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(14l, "TROMBOCIPENIA",1)));
		Case caseToStudy = new Case(1l, "MARCOS", "FORLENZA", "33438259", occurrences, false, false);
		AlarmResult alarmResult = engine.runCase(caseToStudy);
		logger.info("shouldNotDetectDengueAlarmByLocation Final score: " + alarmResult.getTotalScoring() );
		assertEquals(alarmResult.isPosibleDisease(),false);		
	}
	
	@Test
	public void shouldDetectFiebreAmarillaAlarm(){
		List<SymptomOccurrence> occurrences = new ArrayList<SymptomOccurrence>();		
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(3l, "MIALGIAS",0)));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(8l, "HEMORRAGIAS",1)));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(9l, "SHOCK",1)));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(10l, "ICTERICIA",1)));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(11l,"LEUCOPENIA",1)));
		
		Case caseToStudy = new Case(1l, "MARCOS", "FORLENZA", "33438259", occurrences, true, false);
		AlarmResult alarmResult = engine.runCase(caseToStudy);
		logger.info("shouldDetectFiebreAmarillaAlarm Final score: " + alarmResult.getTotalScoring() );
		assertEquals(alarmResult.isPosibleDisease(),true);
		assertEquals(alarmResult.getDisease().getId(),4l);
	}
	
	private Map<Disease, Integer> getDefaultDiseasesScoring(){
		Map<Disease,Integer> result = new HashMap<Disease,Integer>();
		result.put(new Disease(1l, "DENGUE"),20);
		result.put(new Disease(2l, "CHIKUNGUYA"),20);
		result.put(new Disease(3l, "ZIKA"),20);
		result.put(new Disease(4l, "FIEBRE AMARILLA"),20);
		return result;
	}
	
	private List<SymptomsScoringConfiguration> getDefaultSymptomsScoring(){
		List<SymptomsScoringConfiguration> result = new ArrayList<SymptomsScoringConfiguration>();
		
		Map<Disease,Integer> symptomConfig1Valuations = new HashMap<Disease,Integer>();		
		symptomConfig1Valuations.put(new Disease(1l, "DENGUE"),4);
		symptomConfig1Valuations.put(new Disease(2l, "CHIKUNGUYA"),5);
		symptomConfig1Valuations.put(new Disease(3l, "ZIKA"),3);
		symptomConfig1Valuations.put(new Disease(4l, "FIEBRE AMARILLA"),2);		
		SymptomsScoringConfiguration symptomConfig1 = new SymptomsScoringConfiguration(new ValuatedSymptom(1l, "INCUBACION", 0, 4, 1,1), symptomConfig1Valuations);
		result.add(symptomConfig1);
		
		Map<Disease,Integer> symptomConfig2Valuations = new HashMap<Disease,Integer>();		
		symptomConfig2Valuations.put(new Disease(1l, "DENGUE"),4);
		symptomConfig2Valuations.put(new Disease(2l, "CHIKUNGUYA"),5);
		symptomConfig2Valuations.put(new Disease(3l, "ZIKA"),4);
		symptomConfig2Valuations.put(new Disease(4l, "FIEBRE AMARILLA"),4);		
		SymptomsScoringConfiguration symptomConfig2 = new SymptomsScoringConfiguration(new BooleanSymptom(2l, "FIEBRE",0), symptomConfig2Valuations);
		result.add(symptomConfig2);
		
		Map<Disease,Integer> symptomConfig3Valuations = new HashMap<Disease,Integer>();		
		symptomConfig3Valuations.put(new Disease(1l, "DENGUE"),4);
		symptomConfig3Valuations.put(new Disease(2l, "CHIKUNGUYA"),3);
		symptomConfig3Valuations.put(new Disease(3l, "ZIKA"),4);
		symptomConfig3Valuations.put(new Disease(4l, "FIEBRE AMARILLA"),4);		
		SymptomsScoringConfiguration symptomConfig3 = new SymptomsScoringConfiguration(new BooleanSymptom(3l, "MIALGIAS",0), symptomConfig3Valuations);
		result.add(symptomConfig3);
		
		Map<Disease,Integer> symptomConfig4Valuations = new HashMap<Disease,Integer>();		
		symptomConfig4Valuations.put(new Disease(1l, "DENGUE"),4);
		symptomConfig4Valuations.put(new Disease(2l, "CHIKUNGUYA"),5);
		symptomConfig4Valuations.put(new Disease(3l, "ZIKA"),4);
		symptomConfig4Valuations.put(new Disease(4l, "FIEBRE AMARILLA"),3);		
		SymptomsScoringConfiguration symptomConfig4 = new SymptomsScoringConfiguration(new BooleanSymptom(4l, "ARTRALGIAS",0), symptomConfig4Valuations);
		result.add(symptomConfig4);
		
		Map<Disease,Integer> symptomConfig5Valuations = new HashMap<Disease,Integer>();		
		symptomConfig5Valuations.put(new Disease(1l, "DENGUE"),4);
		symptomConfig5Valuations.put(new Disease(2l, "CHIKUNGUYA"),4);
		symptomConfig5Valuations.put(new Disease(3l, "ZIKA"),3);
		symptomConfig5Valuations.put(new Disease(4l, "FIEBRE AMARILLA"),2);		
		SymptomsScoringConfiguration symptomConfig5 = new SymptomsScoringConfiguration(new BooleanSymptom(5l, "CEFALEA",0), symptomConfig5Valuations);
		result.add(symptomConfig5);
		
		Map<Disease,Integer> symptomConfig6Valuations = new HashMap<Disease,Integer>();		
		symptomConfig6Valuations.put(new Disease(1l, "DENGUE"),3);
		symptomConfig6Valuations.put(new Disease(2l, "CHIKUNGUYA"),4);
		symptomConfig6Valuations.put(new Disease(3l, "ZIKA"),5);
		symptomConfig6Valuations.put(new Disease(4l, "FIEBRE AMARILLA"),1);		
		SymptomsScoringConfiguration symptomConfig6 = new SymptomsScoringConfiguration(new BooleanSymptom(6l, "EXANTEMA",0), symptomConfig6Valuations);
		result.add(symptomConfig6);
		
		Map<Disease,Integer> symptomConfig7Valuations = new HashMap<Disease,Integer>();		
		symptomConfig7Valuations.put(new Disease(1l, "DENGUE"),3);
		symptomConfig7Valuations.put(new Disease(2l, "CHIKUNGUYA"),3);
		symptomConfig7Valuations.put(new Disease(3l, "ZIKA"),3);
		symptomConfig7Valuations.put(new Disease(4l, "FIEBRE AMARILLA"),2);		
		SymptomsScoringConfiguration symptomConfig7 = new SymptomsScoringConfiguration(new BooleanSymptom(7l, "DIARREA Y VOMITOS",1), symptomConfig7Valuations);
		result.add(symptomConfig7);
		
		Map<Disease,Integer> symptomConfig8Valuations = new HashMap<Disease,Integer>();		
		symptomConfig8Valuations.put(new Disease(1l, "DENGUE"),4);
		symptomConfig8Valuations.put(new Disease(2l, "CHIKUNGUYA"),2);
		symptomConfig8Valuations.put(new Disease(3l, "ZIKA"),1);
		symptomConfig8Valuations.put(new Disease(4l, "FIEBRE AMARILLA"),4);		
		SymptomsScoringConfiguration symptomConfig8 = new SymptomsScoringConfiguration(new BooleanSymptom(8l, "HEMORRAGIAS",1), symptomConfig8Valuations);
		result.add(symptomConfig8);
		
		Map<Disease,Integer> symptomConfig9Valuations = new HashMap<Disease,Integer>();		
		symptomConfig9Valuations.put(new Disease(1l, "DENGUE"),2);
		symptomConfig9Valuations.put(new Disease(2l, "CHIKUNGUYA"),1);
		symptomConfig9Valuations.put(new Disease(3l, "ZIKA"),1);
		symptomConfig9Valuations.put(new Disease(4l, "FIEBRE AMARILLA"),4);		
		SymptomsScoringConfiguration symptomConfig9 = new SymptomsScoringConfiguration(new BooleanSymptom(9l, "SHOCK",1), symptomConfig9Valuations);
		result.add(symptomConfig9);
		
		Map<Disease,Integer> symptomConfig10Valuations = new HashMap<Disease,Integer>();		
		symptomConfig10Valuations.put(new Disease(1l, "DENGUE"),1);
		symptomConfig10Valuations.put(new Disease(2l, "CHIKUNGUYA"),1);
		symptomConfig10Valuations.put(new Disease(3l, "ZIKA"),1);
		symptomConfig10Valuations.put(new Disease(4l, "FIEBRE AMARILLA"),5);		
		SymptomsScoringConfiguration symptomConfig10 = new SymptomsScoringConfiguration(new BooleanSymptom(10l, "ICTERICIA",1), symptomConfig10Valuations);
		result.add(symptomConfig10);
		
		Map<Disease,Integer> symptomConfig11Valuations = new HashMap<Disease,Integer>();		
		symptomConfig11Valuations.put(new Disease(1l, "DENGUE"),5);
		symptomConfig11Valuations.put(new Disease(2l, "CHIKUNGUYA"),4);
		symptomConfig11Valuations.put(new Disease(3l, "ZIKA"),2);
		symptomConfig11Valuations.put(new Disease(4l, "FIEBRE AMARILLA"),4);		
		SymptomsScoringConfiguration symptomConfig11 = new SymptomsScoringConfiguration(new BooleanSymptom(11l,"LEUCOPENIA",1), symptomConfig11Valuations);
		result.add(symptomConfig11);
		
		Map<Disease,Integer> symptomConfig12Valuations = new HashMap<Disease,Integer>();		
		symptomConfig12Valuations.put(new Disease(1l, "DENGUE"),5);
		symptomConfig12Valuations.put(new Disease(2l, "CHIKUNGUYA"),3);
		symptomConfig12Valuations.put(new Disease(3l, "ZIKA"),2);
		symptomConfig12Valuations.put(new Disease(4l, "FIEBRE AMARILLA"),2);		
		SymptomsScoringConfiguration symptomConfig12 = new SymptomsScoringConfiguration(new BooleanSymptom(12l, "NEUTROPENIA",1), symptomConfig12Valuations);
		result.add(symptomConfig12);
		
		Map<Disease,Integer> symptomConfig13Valuations = new HashMap<Disease,Integer>();		
		symptomConfig13Valuations.put(new Disease(1l, "DENGUE"),4);
		symptomConfig13Valuations.put(new Disease(2l, "CHIKUNGUYA"),5);
		symptomConfig13Valuations.put(new Disease(3l, "ZIKA"),2);
		symptomConfig13Valuations.put(new Disease(4l, "FIEBRE AMARILLA"),4);		
		SymptomsScoringConfiguration symptomConfig13 = new SymptomsScoringConfiguration(new BooleanSymptom(13l, "LINFOPEMIA",1), symptomConfig13Valuations);
		result.add(symptomConfig13);
		
		Map<Disease,Integer> symptomConfig14Valuations = new HashMap<Disease,Integer>();		
		symptomConfig14Valuations.put(new Disease(1l, "DENGUE"),5);
		symptomConfig14Valuations.put(new Disease(2l, "CHIKUNGUYA"),3);
		symptomConfig14Valuations.put(new Disease(3l, "ZIKA"),2);
		symptomConfig14Valuations.put(new Disease(4l, "FIEBRE AMARILLA"),2);		
		SymptomsScoringConfiguration symptomConfig14 = new SymptomsScoringConfiguration(new BooleanSymptom(14l, "TROMBOCIPENIA",1), symptomConfig14Valuations);
		result.add(symptomConfig14);
		
		Map<Disease,Integer> symptomConfig15Valuations = new HashMap<Disease,Integer>();		
		symptomConfig15Valuations.put(new Disease(1l, "DENGUE"),3);
		symptomConfig15Valuations.put(new Disease(2l, "CHIKUNGUYA"),4);
		symptomConfig15Valuations.put(new Disease(3l, "ZIKA"),3);
		symptomConfig15Valuations.put(new Disease(4l, "FIEBRE AMARILLA"),2);		
		SymptomsScoringConfiguration symptomConfig15 = new SymptomsScoringConfiguration(new ValuatedSymptom(15l, "DURACION ENFERMEDAD", 1, 4, 1,0)  , symptomConfig15Valuations);
		result.add(symptomConfig15);		
		
		return result;
	}
	
	
	@SuppressWarnings("unused")
	private List<Symptom> getDefaultSymptom(){
		List<Symptom> result = new ArrayList<Symptom>();
		result.add(new ValuatedSymptom(1l, "INCUBACION", 0, 4, 1,1));
		result.add(new BooleanSymptom(2l, "FIEBRE",0));
		result.add(new BooleanSymptom(3l, "MIALGIAS",0));
		result.add(new BooleanSymptom(4l, "ARTRALGIAS",0));
		result.add(new BooleanSymptom(5l, "CEFALEA",0));
		result.add(new BooleanSymptom(6l, "EXANTEMA",0));
		result.add(new BooleanSymptom(7l, "DIARREA Y VOMITOS",1));
		result.add(new BooleanSymptom(8l, "HEMORRAGIAS",1));
		result.add(new BooleanSymptom(9l, "SHOCK",1));
		result.add(new BooleanSymptom(10l, "ICTERICIA",1));
		result.add(new BooleanSymptom(11l,"LEUCOPENIA",1));
		result.add(new BooleanSymptom(12l, "NEUTROPENIA",1));
		result.add(new BooleanSymptom(13l, "LINFOPEMIA",1));
		result.add(new BooleanSymptom(14l, "TROMBOCIPENIA",1));
		result.add(new ValuatedSymptom(15l, "DURACION ENFERMEDAD", 0, 4, 1,1));
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
