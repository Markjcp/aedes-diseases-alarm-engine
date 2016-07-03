package org.fiuba.aedesalarmengine.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.fiuba.aedesalarmengine.model.configuration.ScoringConfiguration;
import org.fiuba.aedesalarmengine.model.configuration.SymptomsScoringConfiguration;
import org.fiuba.aedesalarmengine.model.disease.Disease;
import org.fiuba.aedesalarmengine.model.engine.Case;
import org.fiuba.aedesalarmengine.model.occurrences.BooleanSymptomOccurrence;
import org.fiuba.aedesalarmengine.model.occurrences.SymptomOccurrence;
import org.fiuba.aedesalarmengine.model.symptom.BooleanSymptom;
import org.fiuba.aedesalarmengine.model.symptom.Symptom;
import org.fiuba.aedesalarmengine.model.symptom.ValuatedSymptom;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = { "org.fiuba.aedesalarmengine.model" })
public class DependencyInjectionConfig {

	@Bean(name = "defaultSymptom")
	public List<Symptom> getDefaultSymptom() {
		List<Symptom> result = new ArrayList<Symptom>();
		result.add(new ValuatedSymptom(1l, "INCUBACION", 0, 4, 1));
		result.add(new BooleanSymptom(2l, "FIEBRE"));
		result.add(new BooleanSymptom(3l, "MIALGIAS"));
		result.add(new BooleanSymptom(4l, "ARTRALGIAS"));
		result.add(new BooleanSymptom(5l, "CEFALEA"));
		result.add(new BooleanSymptom(6l, "EXANTEMA"));
		result.add(new BooleanSymptom(7l, "DIARREA Y VOMITOS"));
		result.add(new BooleanSymptom(8l, "HEMORRAGIAS"));
		result.add(new BooleanSymptom(9l, "SHOCK"));
		result.add(new BooleanSymptom(10l, "ICTERICIA"));
		result.add(new BooleanSymptom(11l, "LEUCOPENIA"));
		result.add(new BooleanSymptom(12l, "NEUTROPENIA"));
		result.add(new BooleanSymptom(13l, "LINFOPEMIA"));
		result.add(new BooleanSymptom(14l, "TROMBOCIPENIA"));
		result.add(new ValuatedSymptom(15l, "DURACION ENFERMEDAD", 0, 4, 1));
		return result;
	}

	@Bean(name = "defaultDiseases")
	public List<Disease> getDefaultDiseases() {
		List<Disease> result = new ArrayList<Disease>();
		result.add(new Disease(1l, "DENGUE"));
		result.add(new Disease(2l, "CHIKUNGUYA"));
		result.add(new Disease(3l, "ZIKA"));
		result.add(new Disease(4l, "FIEBRE AMARILLA"));
		return result;
	}

	@Bean(name = "defaultConfiguration")
	public ScoringConfiguration getDefaultConfiguration() {
		ScoringConfiguration configuration = new ScoringConfiguration();
		configuration.buildConfiguration(getDefaultSymptomsScoring(), getDefaultDiseases(),
				getDefaultDiseasesScoring());
		return configuration;
	}

	@Bean(name = "defaultDiseasesScoring")
	public Map<Disease, Integer> getDefaultDiseasesScoring() {
		Map<Disease, Integer> result = new HashMap<Disease, Integer>();
		result.put(new Disease(1l, "DENGUE"), 20);
		result.put(new Disease(2l, "CHIKUNGUYA"), 20);
		result.put(new Disease(3l, "ZIKA"), 20);
		result.put(new Disease(4l, "FIEBRE AMARILLA"), 20);
		return result;
	}

	@Bean(name = "defaultSymptomsScoring")
	public List<SymptomsScoringConfiguration> getDefaultSymptomsScoring() {
		List<SymptomsScoringConfiguration> result = new ArrayList<SymptomsScoringConfiguration>();

		Map<Disease, Integer> symptomConfig1Valuations = new HashMap<Disease, Integer>();
		symptomConfig1Valuations.put(new Disease(1l, "DENGUE"), 4);
		symptomConfig1Valuations.put(new Disease(2l, "CHIKUNGUYA"), 5);
		symptomConfig1Valuations.put(new Disease(3l, "ZIKA"), 3);
		symptomConfig1Valuations.put(new Disease(4l, "FIEBRE AMARILLA"), 2);
		SymptomsScoringConfiguration symptomConfig1 = new SymptomsScoringConfiguration(
				new ValuatedSymptom(1l, "INCUBACION", 0, 4, 1), symptomConfig1Valuations);
		result.add(symptomConfig1);

		Map<Disease, Integer> symptomConfig2Valuations = new HashMap<Disease, Integer>();
		symptomConfig2Valuations.put(new Disease(1l, "DENGUE"), 4);
		symptomConfig2Valuations.put(new Disease(2l, "CHIKUNGUYA"), 5);
		symptomConfig2Valuations.put(new Disease(3l, "ZIKA"), 4);
		symptomConfig2Valuations.put(new Disease(4l, "FIEBRE AMARILLA"), 4);
		SymptomsScoringConfiguration symptomConfig2 = new SymptomsScoringConfiguration(new BooleanSymptom(2l, "FIEBRE"),
				symptomConfig2Valuations);
		result.add(symptomConfig2);

		Map<Disease, Integer> symptomConfig3Valuations = new HashMap<Disease, Integer>();
		symptomConfig3Valuations.put(new Disease(1l, "DENGUE"), 4);
		symptomConfig3Valuations.put(new Disease(2l, "CHIKUNGUYA"), 3);
		symptomConfig3Valuations.put(new Disease(3l, "ZIKA"), 4);
		symptomConfig3Valuations.put(new Disease(4l, "FIEBRE AMARILLA"), 4);
		SymptomsScoringConfiguration symptomConfig3 = new SymptomsScoringConfiguration(
				new BooleanSymptom(3l, "MIALGIAS"), symptomConfig3Valuations);
		result.add(symptomConfig3);

		Map<Disease, Integer> symptomConfig4Valuations = new HashMap<Disease, Integer>();
		symptomConfig4Valuations.put(new Disease(1l, "DENGUE"), 4);
		symptomConfig4Valuations.put(new Disease(2l, "CHIKUNGUYA"), 5);
		symptomConfig4Valuations.put(new Disease(3l, "ZIKA"), 4);
		symptomConfig4Valuations.put(new Disease(4l, "FIEBRE AMARILLA"), 3);
		SymptomsScoringConfiguration symptomConfig4 = new SymptomsScoringConfiguration(
				new BooleanSymptom(4l, "ARTRALGIAS"), symptomConfig4Valuations);
		result.add(symptomConfig4);

		Map<Disease, Integer> symptomConfig5Valuations = new HashMap<Disease, Integer>();
		symptomConfig5Valuations.put(new Disease(1l, "DENGUE"), 4);
		symptomConfig5Valuations.put(new Disease(2l, "CHIKUNGUYA"), 4);
		symptomConfig5Valuations.put(new Disease(3l, "ZIKA"), 3);
		symptomConfig5Valuations.put(new Disease(4l, "FIEBRE AMARILLA"), 2);
		SymptomsScoringConfiguration symptomConfig5 = new SymptomsScoringConfiguration(
				new BooleanSymptom(5l, "CEFALEA"), symptomConfig5Valuations);
		result.add(symptomConfig5);

		Map<Disease, Integer> symptomConfig6Valuations = new HashMap<Disease, Integer>();
		symptomConfig6Valuations.put(new Disease(1l, "DENGUE"), 3);
		symptomConfig6Valuations.put(new Disease(2l, "CHIKUNGUYA"), 4);
		symptomConfig6Valuations.put(new Disease(3l, "ZIKA"), 5);
		symptomConfig6Valuations.put(new Disease(4l, "FIEBRE AMARILLA"), 1);
		SymptomsScoringConfiguration symptomConfig6 = new SymptomsScoringConfiguration(
				new BooleanSymptom(6l, "EXANTEMA"), symptomConfig6Valuations);
		result.add(symptomConfig6);

		Map<Disease, Integer> symptomConfig7Valuations = new HashMap<Disease, Integer>();
		symptomConfig7Valuations.put(new Disease(1l, "DENGUE"), 3);
		symptomConfig7Valuations.put(new Disease(2l, "CHIKUNGUYA"), 3);
		symptomConfig7Valuations.put(new Disease(3l, "ZIKA"), 3);
		symptomConfig7Valuations.put(new Disease(4l, "FIEBRE AMARILLA"), 2);
		SymptomsScoringConfiguration symptomConfig7 = new SymptomsScoringConfiguration(
				new BooleanSymptom(7l, "DIARREA Y VOMITOS"), symptomConfig7Valuations);
		result.add(symptomConfig7);

		Map<Disease, Integer> symptomConfig8Valuations = new HashMap<Disease, Integer>();
		symptomConfig8Valuations.put(new Disease(1l, "DENGUE"), 4);
		symptomConfig8Valuations.put(new Disease(2l, "CHIKUNGUYA"), 2);
		symptomConfig8Valuations.put(new Disease(3l, "ZIKA"), 1);
		symptomConfig8Valuations.put(new Disease(4l, "FIEBRE AMARILLA"), 4);
		SymptomsScoringConfiguration symptomConfig8 = new SymptomsScoringConfiguration(
				new BooleanSymptom(8l, "HEMORRAGIAS"), symptomConfig8Valuations);
		result.add(symptomConfig8);

		Map<Disease, Integer> symptomConfig9Valuations = new HashMap<Disease, Integer>();
		symptomConfig9Valuations.put(new Disease(1l, "DENGUE"), 2);
		symptomConfig9Valuations.put(new Disease(2l, "CHIKUNGUYA"), 1);
		symptomConfig9Valuations.put(new Disease(3l, "ZIKA"), 1);
		symptomConfig9Valuations.put(new Disease(4l, "FIEBRE AMARILLA"), 4);
		SymptomsScoringConfiguration symptomConfig9 = new SymptomsScoringConfiguration(new BooleanSymptom(9l, "SHOCK"),
				symptomConfig9Valuations);
		result.add(symptomConfig9);

		Map<Disease, Integer> symptomConfig10Valuations = new HashMap<Disease, Integer>();
		symptomConfig10Valuations.put(new Disease(1l, "DENGUE"), 1);
		symptomConfig10Valuations.put(new Disease(2l, "CHIKUNGUYA"), 1);
		symptomConfig10Valuations.put(new Disease(3l, "ZIKA"), 1);
		symptomConfig10Valuations.put(new Disease(4l, "FIEBRE AMARILLA"), 5);
		SymptomsScoringConfiguration symptomConfig10 = new SymptomsScoringConfiguration(
				new BooleanSymptom(10l, "ICTERICIA"), symptomConfig10Valuations);
		result.add(symptomConfig10);

		Map<Disease, Integer> symptomConfig11Valuations = new HashMap<Disease, Integer>();
		symptomConfig11Valuations.put(new Disease(1l, "DENGUE"), 5);
		symptomConfig11Valuations.put(new Disease(2l, "CHIKUNGUYA"), 4);
		symptomConfig11Valuations.put(new Disease(3l, "ZIKA"), 2);
		symptomConfig11Valuations.put(new Disease(4l, "FIEBRE AMARILLA"), 4);
		SymptomsScoringConfiguration symptomConfig11 = new SymptomsScoringConfiguration(
				new BooleanSymptom(11l, "LEUCOPENIA"), symptomConfig11Valuations);
		result.add(symptomConfig11);

		Map<Disease, Integer> symptomConfig12Valuations = new HashMap<Disease, Integer>();
		symptomConfig12Valuations.put(new Disease(1l, "DENGUE"), 5);
		symptomConfig12Valuations.put(new Disease(2l, "CHIKUNGUYA"), 3);
		symptomConfig12Valuations.put(new Disease(3l, "ZIKA"), 2);
		symptomConfig12Valuations.put(new Disease(4l, "FIEBRE AMARILLA"), 2);
		SymptomsScoringConfiguration symptomConfig12 = new SymptomsScoringConfiguration(
				new BooleanSymptom(12l, "NEUTROPENIA"), symptomConfig12Valuations);
		result.add(symptomConfig12);

		Map<Disease, Integer> symptomConfig13Valuations = new HashMap<Disease, Integer>();
		symptomConfig13Valuations.put(new Disease(1l, "DENGUE"), 4);
		symptomConfig13Valuations.put(new Disease(2l, "CHIKUNGUYA"), 5);
		symptomConfig13Valuations.put(new Disease(3l, "ZIKA"), 2);
		symptomConfig13Valuations.put(new Disease(4l, "FIEBRE AMARILLA"), 4);
		SymptomsScoringConfiguration symptomConfig13 = new SymptomsScoringConfiguration(
				new BooleanSymptom(13l, "LINFOPEMIA"), symptomConfig13Valuations);
		result.add(symptomConfig13);

		Map<Disease, Integer> symptomConfig14Valuations = new HashMap<Disease, Integer>();
		symptomConfig14Valuations.put(new Disease(1l, "DENGUE"), 5);
		symptomConfig14Valuations.put(new Disease(2l, "CHIKUNGUYA"), 3);
		symptomConfig14Valuations.put(new Disease(3l, "ZIKA"), 2);
		symptomConfig14Valuations.put(new Disease(4l, "FIEBRE AMARILLA"), 2);
		SymptomsScoringConfiguration symptomConfig14 = new SymptomsScoringConfiguration(
				new BooleanSymptom(14l, "TROMBOCIPENIA"), symptomConfig14Valuations);
		result.add(symptomConfig14);

		Map<Disease, Integer> symptomConfig15Valuations = new HashMap<Disease, Integer>();
		symptomConfig15Valuations.put(new Disease(1l, "DENGUE"), 3);
		symptomConfig15Valuations.put(new Disease(2l, "CHIKUNGUYA"), 4);
		symptomConfig15Valuations.put(new Disease(3l, "ZIKA"), 3);
		symptomConfig15Valuations.put(new Disease(4l, "FIEBRE AMARILLA"), 2);
		SymptomsScoringConfiguration symptomConfig15 = new SymptomsScoringConfiguration(
				new ValuatedSymptom(15l, "DURACION ENFERMEDAD", 0, 4, 1), symptomConfig15Valuations);
		result.add(symptomConfig15);

		return result;
	}

	@Bean(name = "caseExample")
	public Case getCaseExample() {
		List<SymptomOccurrence> occurrences = new ArrayList<SymptomOccurrence>();
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(3l, "MIALGIAS")));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(8l, "HEMORRAGIAS")));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(9l, "SHOCK")));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(10l, "ICTERICIA")));
		occurrences.add(new BooleanSymptomOccurrence(new BooleanSymptom(11l, "LEUCOPENIA")));

		Case caseToStudy = new Case(1l, "MARCOS", "FORLENZA", "33438259", occurrences, true, false);
		return caseToStudy;
	}
}
