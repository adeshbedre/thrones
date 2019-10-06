package com.geektrust.tameofthrones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import com.geektrust.model.BallotMessage;
import com.geektrust.model.SecretMessage;
import com.geektrust.tameofthrones.constants.TameOfThronesConstants;

public class BreakerOfChains implements SoutherosRuler {

	private List<String> contestantList;

	private RulerPrinter rulerPrinter;

	private MessageValidator messageValidator;

	private static int RANDOM_BALLOT_PICK = 6;

	public BreakerOfChains(List<String> contestantList, RulerPrinter rulerPrinter, MessageValidator messageValidator) {
		super();
		this.contestantList = contestantList;
		this.rulerPrinter = rulerPrinter;
		this.messageValidator = messageValidator;
	}

	@Override
	public void findRulerOfSoutheros() {
		Map<String, List<String>> winnerMap = new HashMap<String, List<String>>();
		while (true) {
			List<BallotMessage> ballotMessageList = MessageFactory.generateBallotMessages(this.contestantList);

			List<BallotMessage> filteredBallotList = this.pickFromBallot(ballotMessageList);

			List<BallotMessage> filteredValidBallotList = this.extractValidMessages(filteredBallotList);

			Map<String, List<String>> ballotMap = countBallot(filteredValidBallotList);

			winnerMap = this.findWinners(ballotMap);
			if (winnerMap.size() == TameOfThronesConstants.ONE_RULER) {
				break;
			}

		}
		Entry<String, List<String>> entrySet = winnerMap.entrySet().iterator().next();
		rulerPrinter.printRuler(entrySet.getKey(), entrySet.getValue());

	}

	private List<BallotMessage> extractValidMessages(List<BallotMessage> filteredBallotList) {
		Iterator<BallotMessage> ballotItertor = filteredBallotList.listIterator();
		while (ballotItertor.hasNext()) {
			BallotMessage ballotMessage = ballotItertor.next();
			SecretMessage secretMessage = ballotMessage.getReceiverSecretMessage();
			if (!messageValidator.isValidMessage(secretMessage)) {
				ballotItertor.remove();
			}
		}
		return filteredBallotList;
	}

	private List<BallotMessage> pickFromBallot(List<BallotMessage> ballotMessageList) {
		Set<BallotMessage> filteredUniqueBallotMessageList = new HashSet<>();
		Random random = new Random();
		for (int i = 0; i < RANDOM_BALLOT_PICK; i++) {
			filteredUniqueBallotMessageList.add(ballotMessageList.get(random.nextInt(ballotMessageList.size())));
		}
		return new ArrayList<>(filteredUniqueBallotMessageList);
	}

	private Map<String, List<String>> countBallot(List<BallotMessage> ballotMessageList) {
		Map<String, List<String>> winnerMap = new HashMap<>();
		for (BallotMessage ballotMessage : ballotMessageList) {
			if (!winnerMap.containsKey(ballotMessage.getSenderKingdom().getName())) {
				winnerMap.put(ballotMessage.getSenderKingdom().getName(), new ArrayList<>());
			}
			winnerMap.get(ballotMessage.getSenderKingdom().getName())
					.add(ballotMessage.getReceiverSecretMessage().getKingdom().getName());
		}
		return winnerMap;
	}

	private Map<String, List<String>> findWinners(Map<String, List<String>> ballotMap) {
		Map<String, List<String>> winnerMap = new HashMap<String, List<String>>();
		int maxVotes = 0;
		for (Map.Entry<String, List<String>> ballotEntrySet : ballotMap.entrySet()) {
			if (ballotEntrySet.getValue().size() > maxVotes) {
				maxVotes = ballotEntrySet.getValue().size();
			}
		}
		for (Map.Entry<String, List<String>> ballotEntrySet : ballotMap.entrySet()) {
			if (ballotEntrySet.getValue().size() == maxVotes) {
				winnerMap.put(ballotEntrySet.getKey(), ballotEntrySet.getValue());
			}
		}
		return winnerMap;
	}
}
