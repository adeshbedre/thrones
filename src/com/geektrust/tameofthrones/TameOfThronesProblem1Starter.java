package com.geektrust.tameofthrones;

import java.util.ArrayList;
import java.util.List;

import com.geektrust.model.EmblemEnum;
import com.geektrust.model.MessageDTO;
import com.geektrust.tameofthrones.constants.TameOfThronesConstants;

public class TameOfThronesProblem1Starter {

	public static void main(String[] args) {
		MessageDTO problem1Input1 = new MessageDTO("Air", "oaaawaala");

		MessageDTO problem1Input2 = new MessageDTO("Land", "a1d22n333a4444p");

		MessageDTO problem1Input3 = new MessageDTO("Ice", "zmzmzmzaztzozh");

		List<MessageDTO> problem1InputList = new ArrayList<MessageDTO>();
		problem1InputList.add(problem1Input1);
		problem1InputList.add(problem1Input2);
		problem1InputList.add(problem1Input3);
		TameOfThronesProblem1Starter tameOfThronesStarter = new TameOfThronesProblem1Starter();
		tameOfThronesStarter.golderCrown(problem1InputList);

	}

	private void golderCrown(List<MessageDTO> messageDTOList) {
		List<String> alliesList = new ArrayList<String>();
		OutputService outputService = new OutputService();
		SecretMessageService secretMessageService = new SecretMessageService();
		if (messageDTOList.size() >= TameOfThronesConstants.MIN_RULER_COUNT) {
			alliesList = secretMessageService.validateSecretMessages(messageDTOList);
		}
		outputService.printGoldenThroneWinner(alliesList);
	}


}
