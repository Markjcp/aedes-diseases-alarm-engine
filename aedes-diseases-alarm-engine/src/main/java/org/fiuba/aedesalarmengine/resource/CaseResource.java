package org.fiuba.aedesalarmengine.resource;

import java.io.IOException;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.fiuba.aedesalarmengine.model.configuration.ScoringConfiguration;
import org.fiuba.aedesalarmengine.model.engine.AlarmResult;
import org.fiuba.aedesalarmengine.model.engine.Case;
import org.fiuba.aedesalarmengine.model.engine.SimpleAedesDiseasesEngine;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Component
@Path("/case")
public class CaseResource {
	
	@Resource(name="defaultConfiguration")
	private ScoringConfiguration defaultConfiguration;
	
	@Resource(name = "caseExample")
	private Case caseExample;	
	
	@POST
	@Path("run")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public AlarmResult run(Case caseToEvaluate ) throws JsonParseException, JsonMappingException, IOException{
		return new SimpleAedesDiseasesEngine(defaultConfiguration).runCase(caseToEvaluate);
	}
	
	@GET
	@Path("caseExample")
    @Produces("application/json")
	public Case caseExample(){
		return caseExample;
	}

}
