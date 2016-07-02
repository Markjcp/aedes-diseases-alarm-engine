package org.fiuba.aedesalarmengine.model.symptom;

public abstract class Symptom {
	
	private String name;
	
	private long id;

	public Symptom(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}	
}
