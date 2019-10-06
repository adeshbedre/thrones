package com.geektrust.tameofthrones;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.geektrust.model.BallotMessage;
import com.geektrust.model.EmblemEnum;
import com.geektrust.model.Kingdom;
import com.geektrust.model.RandomMessage;
import com.geektrust.model.SecretMessage;

public class MessageFactory {

	public static List<BallotMessage> generateBallotMessages(List<String> contestantList) {
		List<Kingdom> kingdomList = Kingdoms.fetchAllKingdoms();
		List<BallotMessage> ballotMessageList = new ArrayList<>();
		Random random = new Random();
		for (String contestant : contestantList) {
			for (Kingdom kingdom : kingdomList) {
				if (!contestantList.contains(kingdom.getName())) {
					String message = RandomMessage.messageList.get(random.nextInt(RandomMessage.messageList.size()));
					Kingdom senderKingdom = new Kingdom(contestant, EmblemEnum.valueOf(contestant).toString());
					SecretMessage secretMessage = new SecretMessage(kingdom, message);
					BallotMessage ballotMessage = new BallotMessage(senderKingdom, secretMessage);
					ballotMessageList.add(ballotMessage);
				}
			}
		}

		return ballotMessageList;
	}

	public static List<SecretMessage> generateSecretMessages(Map<String, String> secretMessageByKingdomMap) {
		List<SecretMessage> secretMessageList = new ArrayList<>();
		List<Kingdom> kingdomList = Kingdoms.fetchAllKingdoms();
		for (Kingdom kingdom : kingdomList) {
			if (secretMessageByKingdomMap.containsKey(kingdom.getName())) {
				SecretMessage secretMessage = new SecretMessage(kingdom,
						secretMessageByKingdomMap.get(kingdom.getName()));
				secretMessageList.add(secretMessage);
			}
		}
		return secretMessageList;
	}
}
