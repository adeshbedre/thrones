package com.geektrust.model;

public enum EmblemEnum {
	
	LAND("PANDA"),WATER("OCTUPUS"),ICE("MAMMOTH"),AIR("OWL"),FIRE("DRAGON");
	
	private String animal;
	
	EmblemEnum(String animal){
		this.animal = animal;
	}
	
	public String getAnimal() {
		return this.animal;
	}
}
