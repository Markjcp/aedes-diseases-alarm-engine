package org.fiuba.aedesalarmengine.model;

public class Disease {

	private Long id;
	
	private String name;
	
	public Disease(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	
}
