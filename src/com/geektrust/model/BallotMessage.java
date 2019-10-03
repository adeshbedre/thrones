package com.geektrust.model;

public class BallotMessage extends SecretMessage {
	
	private String receiver;

	public BallotMessage(String sender, String receiver, String message) {
		super(sender,message);
		this.receiver = receiver;
	}

	public String getReceiver() {
		return receiver;
	}	
	
}
