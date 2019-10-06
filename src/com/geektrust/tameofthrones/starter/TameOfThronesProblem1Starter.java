package com.geektrust.tameofthrones.starter;

import java.util.HashMap;
import java.util.Map;

import com.geektrust.tameofthrones.GoldenThrone;
import com.geektrust.tameofthrones.GoldenThronePrinter;
import com.geektrust.tameofthrones.MessageValidator;
import com.geektrust.tameofthrones.RulerPrinter;
import com.geektrust.tameofthrones.SoutherosRuler;

public class TameOfThronesProblem1Starter {

	public static void main(String[] args) {
		MessageValidator messageValidator = new MessageValidator();
		RulerPrinter rulerPrinter = new GoldenThronePrinter();
		Map<String, String> secretMessageByKingdomMap = new HashMap<>();
		secretMessageByKingdomMap.put("AIR", "oaaawaala");
		secretMessageByKingdomMap.put("LAND", "a1d22n333a4444p");
		secretMessageByKingdomMap.put("ICE", "zmzmzmzaztzozh");
		SoutherosRuler southerosRuler = new GoldenThrone(messageValidator, rulerPrinter, secretMessageByKingdomMap);
		southerosRuler.findRulerOfSoutheros();
	}
}
