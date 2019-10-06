package com.geektrust.model;

public class BallotMessage {

	private Kingdom senderKingdom;

	private SecretMessage receiverSecretMessage;

	public BallotMessage(Kingdom senderKingdom, SecretMessage receiverSecretMessage) {
		super();
		this.senderKingdom = senderKingdom;
		this.receiverSecretMessage = receiverSecretMessage;
	}

	public Kingdom getSenderKingdom() {
		return senderKingdom;
	}

	public SecretMessage getReceiverSecretMessage() {
		return receiverSecretMessage;
	}

}
