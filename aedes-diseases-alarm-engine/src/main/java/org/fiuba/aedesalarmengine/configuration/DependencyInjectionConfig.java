package org.fiuba.aedesalarmengine.configuration;

import java.util.ArrayList;
import java.util.List;

import org.fiuba.aedesalarmengine.model.Disease;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value={"org.fiuba.aedesalarmengine.model"})
public class DependencyInjectionConfig {
	
	@Bean(name="defaultDiseases")
	public List<Disease> getDefaultDiseases(){
		List<Disease> result = new ArrayList<Disease>();
		result.add(new Disease(1L, "DENGUE"));
		result.add(new Disease(1L, "CHIKUNGUYA"));
		return result;
	}
}
