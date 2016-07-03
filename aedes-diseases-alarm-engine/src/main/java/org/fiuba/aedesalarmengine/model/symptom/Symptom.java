package org.fiuba.aedesalarmengine.model.symptom;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = As.PROPERTY, property = "@class")
@JsonSubTypes({ @Type(value = ValuatedSymptom.class, name = "ValuatedSymptom"),
		@Type(value = BooleanSymptom.class, name = "BooleanSymptom") })
public abstract class Symptom {
	
	private String name;
	
	private long id;
	
	private int order;
	
	public Symptom(){
		super();
	}

	public Symptom(long id, String name, int order) {
		super();
		this.id = id;
		this.name = name;
		this.order = order;
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}	
}
