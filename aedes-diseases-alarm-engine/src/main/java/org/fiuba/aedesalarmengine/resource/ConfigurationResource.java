package org.fiuba.aedesalarmengine.resource;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.fiuba.aedesalarmengine.model.configuration.ScoringConfiguration;
import org.fiuba.aedesalarmengine.model.configuration.SymptomsScoringConfiguration;
import org.fiuba.aedesalarmengine.model.disease.Disease;
import org.fiuba.aedesalarmengine.model.symptom.Symptom;
import org.springframework.stereotype.Component;

@Component
@Path("/config")
public class ConfigurationResource {
	
	@Resource(name="defaultSymptom")
	private List<Symptom> defaultSymptom;
	
	@Resource(name="defaultDiseases")
	private List<Disease> defaultDiseases;
	
	@Resource(name="defaultConfiguration")
	private ScoringConfiguration defaultConfiguration;
	
	@Resource(name="defaultSymptomsScoring")
	private List<SymptomsScoringConfiguration> defaultSymptomsScoring;
	
	@Resource(name="defaultDiseasesScoring")
	private Map<Disease, Integer> defaultDiseasesScoring;
	
	
	
	@GET
	@Path("symptoms")
    @Produces("application/json")
	public List<Symptom> symptoms(){
		return defaultSymptom;
	}
	
	@GET
	@Path("diseases")
    @Produces("application/json")
	public List<Disease> diseases(){
		return defaultDiseases;
	}
	
	@GET
	@Path("configuration")
    @Produces("application/json")
	public ScoringConfiguration defaultConfiguration(){
		return defaultConfiguration;
	}
	
	@GET
	@Path("defaultSymptomsScoring")
    @Produces("application/json")
	public List<SymptomsScoringConfiguration> defaultSymptomsScoring(){
		return defaultSymptomsScoring;
	}
	
	@GET
	@Path("defaultDiseasesScoring")
    @Produces("application/json")
	public Map<Disease, Integer> defaultDiseasesScoring(){
		return defaultDiseasesScoring;
	}	

}
