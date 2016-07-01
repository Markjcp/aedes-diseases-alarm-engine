package org.fiuba.aedesalarmengine.test;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsIntroduction {
    private String topic;
    
    public DroolsIntroduction(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }
        
    public String introduceYourself() {
        return "Drools 6.2.0.Final";
    }
    
    public static void main(String[] args) {
		System.out.println("Hello world");
	}
}