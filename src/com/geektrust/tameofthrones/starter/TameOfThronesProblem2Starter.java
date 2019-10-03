package com.geektrust.tameofthrones.starter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.geektrust.model.EmblemEnum;
import com.geektrust.model.SecretMessage;
import com.geektrust.tameofthrones.MessageValidator;
import com.geektrust.tameofthrones.OutputWriter;
import com.geektrust.tameofthrones.constants.TameOfThronesConstants;

public class TameOfThronesProblem2Starter {



	public static void main(String[] args) {
		List<String> contestantList = new ArrayList<String>();
		contestantList.add(EmblemEnum.ICE.toString());
		contestantList.add(EmblemEnum.LAND.toString());
		contestantList.add(EmblemEnum.AIR.toString());
		TameOfThronesProblem2Starter tameOfThronesProblem2Starter = new TameOfThronesProblem2Starter();
		tameOfThronesProblem2Starter.breakerOfChains(contestantList);

	}

	private void breakerOfChains(List<String> contestantList) {
		OutputWriter outputService = new OutputWriter();
		MessageValidator messageValidator = new MessageValidator();
		Random random = new Random();
		boolean rulerFlag = true;
		List<String> finalAlliesList = new ArrayList<String>();
		while (rulerFlag) {
			Map<String, List<String>> ballotMap = new HashMap<String, List<String>>();
			List<String> alliesList = new ArrayList<String>();
			for (String contestant : contestantList) {
				List<SecretMessage> messageDTOList = new ArrayList<SecretMessage>();
				for (EmblemEnum kingdom : EmblemEnum.values()) {
					if (!contestantList.contains(kingdom.toString())) {
						String message = messageList.get(random.nextInt(messageList.size()));
						SecretMessage messageDTO = new SecretMessage(kingdom.toString(), message);
						messageDTOList.add(messageDTO);
					}
				}
				alliesList = messageValidator.validateSecretMessages(messageDTOList);

				ballotMap.put(contestant, alliesList);
			}
			contestantList = findTie(ballotMap);
			if (contestantList.size() == TameOfThronesConstants.ONE_RULER) {
				finalAlliesList = ballotMap.get(contestantList.get(TameOfThronesConstants.INDEX_ZERO));
				rulerFlag = false;
			}

		}
		outputService.printBreakerOfChainsWinner(contestantList.get(TameOfThronesConstants.INDEX_ZERO),
				finalAlliesList);
	}

	private List<String> findTie(Map<String, List<String>> ballotMap) {
		List<String> winnerList = new ArrayList<String>();
		int maxVotes = 0;
		for (Map.Entry<String, List<String>> ballotEntrySet : ballotMap.entrySet()) {
			if (ballotEntrySet.getValue().size() > maxVotes) {
				maxVotes = ballotEntrySet.getValue().size();
			}
		}
		for (Map.Entry<String, List<String>> ballotEntrySet : ballotMap.entrySet()) {
			if (ballotEntrySet.getValue().size() == maxVotes) {
				winnerList.add(ballotEntrySet.getKey());
			}
		}
		return winnerList;
	}

}
