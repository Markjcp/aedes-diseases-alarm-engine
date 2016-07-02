package org.fiuba.aedesalarmengine;

import org.fiuba.aedesalarmengine.resource.ConfigurationResource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class AedesAlarmEngine {
	public static void main(String[] args) {
		SpringApplication.run(AedesAlarmEngine.class, args);
	}
}