package org.fiuba.aedesalarmengine.configuration;

import org.fiuba.aedesalarmengine.resource.ConfigurationResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {
	
	public JerseyConfig(){
		register(ConfigurationResource.class);
	}

}
