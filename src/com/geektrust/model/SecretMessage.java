package com.geektrust.model;

public class SecretMessage {

	private Kingdom kingdom;

	private String message;

	public SecretMessage(Kingdom kingdom, String message) {
		super();
		this.kingdom = kingdom;
		this.message = message;
	}

	public Kingdom getKingdom() {
		return kingdom;
	}

	public String getMessage() {
		return message;
	}


}
