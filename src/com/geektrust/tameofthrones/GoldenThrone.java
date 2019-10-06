package com.geektrust.tameofthrones;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.geektrust.model.SecretMessage;

public class GoldenThrone implements SoutherosRuler {

	private MessageValidator messageValidator;
	
	private RulerPrinter rulerPrinter;
	
	private Map<String, String> secretMessageByKingdomMap;
	
	public GoldenThrone(MessageValidator messageValidator, RulerPrinter rulerPrinter,
			Map<String, String> secretMessageByKingdomMap) {
		super();
		this.messageValidator = messageValidator;
		this.rulerPrinter = rulerPrinter;
		this.secretMessageByKingdomMap = secretMessageByKingdomMap;
	}

	public void setSecretMessageByKingdomMap(Map<String, String> secretMessageByKingdomMap) {
		this.secretMessageByKingdomMap = secretMessageByKingdomMap;
	}

	@Override
	public void findRulerOfSoutheros() {
		List<String> alliesList = new ArrayList<String>();
		List<SecretMessage> secretMessageList = MessageFactory.generateSecretMessages(secretMessageByKingdomMap);
		for (SecretMessage secretMessage : secretMessageList) {
			if (messageValidator.isValidMessage(secretMessage)) {
				alliesList.add(secretMessage.getKingdom().getName());
			}
		}
		rulerPrinter.printRuler("Shan", alliesList);
	}

}
