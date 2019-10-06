package com.geektrust.model;

public enum SystemEnum {
	
	GOLDENTHRONE("GOLDENTHRONE"), BREAKEROFCHAINS("BREAKEROFCHAINS");

	private String system;

	SystemEnum(String system) {
		this.system = system;
	}

	public String getSystem() {
		return this.system;
	}
}
