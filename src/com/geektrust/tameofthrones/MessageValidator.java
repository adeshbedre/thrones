package com.geektrust.tameofthrones;

import com.geektrust.model.SecretMessage;

public class MessageValidator {

	public boolean isValidMessage(SecretMessage secretMessage) {
		String message = secretMessage.getMessage().toUpperCase(); 
		String animal = secretMessage.getKingdom().getEmblem();
		int matchCount = 0;
		for (int animalIndex = 0; animalIndex < animal.length(); animalIndex++) {
			if (message.contains(String.valueOf(animal.charAt(animalIndex)))) {
				matchCount++;
			}
		}
		if (matchCount == animal.length()) {
			return true;
		} else {
			return false;
		}
	}

}
