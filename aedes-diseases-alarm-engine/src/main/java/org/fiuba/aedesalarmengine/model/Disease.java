package org.fiuba.aedesalarmengine.model;

public class Disease {

	private long id;

	private String name;

	public Disease(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
