package com.geektrust.tameofthrones.starter;

import java.util.ArrayList;
import java.util.List;

import com.geektrust.model.SecretMessage;
import com.geektrust.tameofthrones.MessageValidator;
import com.geektrust.tameofthrones.OutputWriter;
import com.geektrust.tameofthrones.constants.TameOfThronesConstants;

public class TameOfThronesProblem1Starter {

	public static void main(String[] args) {
		SecretMessage problem1Input1 = new SecretMessage("Air", "oaaawaala");

		SecretMessage problem1Input2 = new SecretMessage("Land", "a1d22n333a4444p");

		SecretMessage problem1Input3 = new SecretMessage("Ice", "zmzmzmzaztzozh");

		List<SecretMessage> problem1InputList = new ArrayList<SecretMessage>();
		problem1InputList.add(problem1Input1);
		problem1InputList.add(problem1Input2);
		problem1InputList.add(problem1Input3);
		TameOfThronesProblem1Starter tameOfThronesStarter = new TameOfThronesProblem1Starter();
		tameOfThronesStarter.golderCrown(problem1InputList);

	}

	private void golderCrown(List<SecretMessage> messageDTOList) {
		List<String> alliesList = new ArrayList<String>();
		OutputWriter outputService = new OutputWriter();
		MessageValidator secretMessageService = new MessageValidator();
		if (messageDTOList.size() >= TameOfThronesConstants.MIN_RULER_COUNT) {
			alliesList = secretMessageService.validateSecretMessages(messageDTOList);
		}
		outputService.printGoldenThroneWinner(alliesList);
	}


}
