package org.fiuba.aedesalarmengine.configuration;

import java.util.ArrayList;
import java.util.List;

import org.fiuba.aedesalarmengine.model.BooleanSymptom;
import org.fiuba.aedesalarmengine.model.Disease;
import org.fiuba.aedesalarmengine.model.Symptom;
import org.fiuba.aedesalarmengine.model.ValuatedSymptom;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value={"org.fiuba.aedesalarmengine.model"})
public class DependencyInjectionConfig {
	
	@Bean(name="defaultSymptom")
	public List<Symptom> getDefaultSymptom(){
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
		result.add(new BooleanSymptom(11l,"LEUCOPENIA"));
		result.add(new BooleanSymptom(12l, "NEUTROPENIA"));
		result.add(new BooleanSymptom(13l, "LINFOPEMIA"));
		result.add(new BooleanSymptom(14l, "TROMBOCIPENIA"));
		result.add(new ValuatedSymptom(15l, "DURACION ENFERMEDAD", 0, 4, 1));
		return result;
	}
	
	@Bean(name="defaultDiseases")
	public List<Disease> getDefaultDiseases(){
		List<Disease> result = new ArrayList<Disease>();
		result.add(new Disease(1l, "DENGUE"));
		result.add(new Disease(2l, "CHIKUNGUYA"));
		result.add(new Disease(3l, "ZIKA"));
		result.add(new Disease(4l, "FIEBRE AMARILLA"));
		return result;
	}
}
