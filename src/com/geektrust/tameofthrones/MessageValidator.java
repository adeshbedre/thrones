package com.geektrust.tameofthrones;

import java.util.ArrayList;
import java.util.List;

import com.geektrust.model.EmblemEnum;
import com.geektrust.model.SecretMessage;

public class MessageValidator {

	public List<String> validateSecretMessages(List<SecretMessage> messageDTOList) {
		List<String> alliesList = new ArrayList<String>();
		for (SecretMessage secretMessage : messageDTOList) {
			if (verifyMessage(secretMessage)) {
				alliesList.add(secretMessage.getSenderKingdom());
			}
		}
		return alliesList;
	}

	private String findAnimal(String emblem) {
		String animal = null;
		switch (EmblemEnum.valueOf(emblem.toUpperCase())) {
		case LAND:
			animal = EmblemEnum.LAND.getAnimal();
			break;
		case WATER:
			animal = EmblemEnum.WATER.getAnimal();
			break;
		case ICE:
			animal = EmblemEnum.ICE.getAnimal();
			break;
		case AIR:
			animal = EmblemEnum.AIR.getAnimal();
			break;
		case FIRE:
			animal = EmblemEnum.FIRE.getAnimal();
			break;
		}
		return animal;
	}

	public boolean verifyMessage(SecretMessage secretMessage) {
		String message = secretMessage.getMessage(); 
		String animal = findAnimal(secretMessage.getSenderKingdom());
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
