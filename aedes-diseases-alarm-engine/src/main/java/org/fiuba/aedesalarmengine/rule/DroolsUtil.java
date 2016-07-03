package org.fiuba.aedesalarmengine.rule;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsUtil {
	
	private static final String KSESSION_RULES = "ksession-rules";

	private static DroolsUtil instance;
	
	private KieSession kSession;
	
	private DroolsUtil(){
		KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        kSession = kContainer.newKieSession(KSESSION_RULES);		
	}
	
	public static synchronized DroolsUtil getInstance(){
		if(instance==null){
			instance = new DroolsUtil();
		}
		return instance;
	}

	public KieSession getkSession() {
		return kSession;
	}
}
