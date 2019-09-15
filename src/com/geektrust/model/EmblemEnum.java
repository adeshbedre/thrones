package com.geektrust.model;

public enum EmblemEnum {
	
	LAND("Panda"),WATER("Octopus"),ICE("Mammoth"),AIR("Owl"),FIRE("Dragon");
	
	private String animal;
	
	EmblemEnum(String animal){
		this.animal = animal;
	}
	
	public String getAnimal() {
		return this.animal;
	}
}
