package com.geektrust.model;

public class SecretMessage {

	private String senderKingdom;

	private String message;

	public SecretMessage(String kingdom, String message) {
		super();
		this.senderKingdom = kingdom;
		this.message = message;
	}

	public String getSenderKingdom() {
		return senderKingdom;
	}

	public String getMessage() {
		return message;
	}
}
