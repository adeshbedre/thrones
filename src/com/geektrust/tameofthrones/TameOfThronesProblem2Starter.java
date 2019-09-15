package com.geektrust.tameofthrones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.geektrust.model.EmblemEnum;
import com.geektrust.model.MessageDTO;
import com.geektrust.tameofthrones.constants.TameOfThronesConstants;

public class TameOfThronesProblem2Starter {

	public static final List<String> messageList = new ArrayList<String>();

	static {
		messageList.add("Summer is coming");
		messageList.add("a1d22n333a4444p");
		messageList.add("oaaawaala");
		messageList.add("zmzmzmzaztzozh");
		messageList.add("Go, risk it all");
		messageList.add("Let's swing the sword together");
		messageList.add("Die or play the tame of thrones");
		messageList.add("Ahoy! Fight for me with men and money");
		messageList.add("Drag on Martin!");
		messageList.add("When you play the tame of thrones, you win or you die.");
		messageList.add("What could we say to the Lord of Death? Game on?");
		messageList.add("Turn us away, and we will burn you first");
		messageList.add("Death is so terribly final, while life is full of possibilities.");
		messageList.add("You Win or You Die");
		messageList.add("His watch is Ended");
		messageList.add("Sphinx of black quartz, judge my dozen vows");
		messageList.add("Fear cuts deeper than swords, My Lord.");
		messageList.add("Different roads sometimes lead to the same castle.");
		messageList.add("A DRAGON IS NOT A SLAVE.");
		messageList.add("Do not waste paper");
		messageList.add("Go ring all the bells");
		messageList.add("Crazy Fredrick bought many very exquisite pearl, emerald and diamond jewels.");
		messageList.add("The quick brown fox jumps over a lazy dog multiple times.");
		messageList.add("We promptly judged antique ivory buckles for the next prize.");
		messageList.add("Walar Morghulis: All men must die.");
	}

	public static void main(String[] args) {
		List<String> contestantList = new ArrayList<String>();
		contestantList.add(EmblemEnum.ICE.toString());
		contestantList.add(EmblemEnum.LAND.toString());
		contestantList.add(EmblemEnum.AIR.toString());
		TameOfThronesProblem2Starter tameOfThronesProblem2Starter = new TameOfThronesProblem2Starter();
		tameOfThronesProblem2Starter.breakerOfChains(contestantList);

	}

	private void breakerOfChains(List<String> contestantList) {
		OutputService outputService = new OutputService();
		SecretMessageService secretMessageService = new SecretMessageService();
		Random random = new Random();
		boolean rulerFlag = true;
		List<String> finalAlliesList = new ArrayList<String>();
		while (rulerFlag) {
			Map<String, List<String>> ballotMap = new HashMap<String, List<String>>();
			List<String> alliesList = new ArrayList<String>();
			for (String contestant : contestantList) {
				List<MessageDTO> messageDTOList = new ArrayList<MessageDTO>();
				for (EmblemEnum kingdom : EmblemEnum.values()) {
					if (!contestantList.contains(kingdom.toString())) {
						String message = messageList.get(random.nextInt(messageList.size()));
						MessageDTO messageDTO = new MessageDTO(kingdom.toString(), message);
						messageDTOList.add(messageDTO);
					}
				}
				alliesList = secretMessageService.validateSecretMessages(messageDTOList);

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
