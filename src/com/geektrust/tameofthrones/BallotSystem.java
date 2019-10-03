package com.geektrust.tameofthrones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.geektrust.model.BallotMessage;
import com.geektrust.model.EmblemEnum;
import com.geektrust.model.RandomMessage;
import com.geektrust.model.SecretMessage;
import com.geektrust.tameofthrones.constants.TameOfThronesConstants;

public class BallotSystem {

	private List<String> contestantList;

	private OutputWriter outputService;

	private MessageValidator messageValidator;

	public BallotSystem(List<String> contestantList, OutputWriter outputService, MessageValidator messageValidator) {
		super();
		this.contestantList = contestantList;
		this.outputService = outputService;
		this.messageValidator = messageValidator;
	}

	public void findRuler() {
		Random random = new Random();
		boolean rulerFlag = true;
		List<String> finalAlliesList = new ArrayList<String>();
		while (rulerFlag) {
			Map<String, List<String>> alliesByRulerMap = new HashMap<String, List<String>>();
			
			generateValidSecretMessages(random);
			contestantList = findTie(alliesByRulerMap);
			if (contestantList.size() == TameOfThronesConstants.ONE_RULER) {
				finalAlliesList = alliesByRulerMap.get(contestantList.get(TameOfThronesConstants.INDEX_ZERO));
				rulerFlag = false;
			}

		}
		outputService.printBreakerOfChainsWinner(contestantList.get(TameOfThronesConstants.INDEX_ZERO),
				finalAlliesList);
	}

	private void generateValidSecretMessages(Random random) {
		for (String contestant : contestantList) {
			List<SecretMessage> ballotMessageList = new ArrayList<>();
			for (EmblemEnum kingdom : EmblemEnum.values()) {
				if (!contestantList.contains(kingdom.toString())) {

					String message = RandomMessage.messageList
							.get(random.nextInt(RandomMessage.messageList.size()));
					BallotMessage ballotMessage = new BallotMessage(kingdom.toString(), contestant, message)
					ballotMessageList.add(ballotMessage);
				}
			}
			List<String> alliesList = messageValidator.validateSecretMessages(ballotMessageList);
//
//				alliesByRulerMap.put(contestant, alliesList);
		}
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
