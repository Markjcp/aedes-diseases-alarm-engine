package org.fiuba.aedesalarmengine.resource;

import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.fiuba.aedesalarmengine.model.Disease;
import org.fiuba.aedesalarmengine.model.Symptom;
import org.springframework.stereotype.Component;

@Component
@Path("/config")
public class ConfigurationResource {
	
	@Resource(name="defaultSymptom")
	private List<Symptom> defaultSymptom;
	
	@Resource(name="defaultDiseases")
	private List<Disease> defaultDiseases;
	
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

}
