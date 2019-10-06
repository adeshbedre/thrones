package com.geektrust.tameofthrones.starter;

import java.util.ArrayList;
import java.util.List;

import com.geektrust.model.EmblemEnum;
import com.geektrust.tameofthrones.BreakerOfChains;
import com.geektrust.tameofthrones.BreakerOfChainsPrinter;
import com.geektrust.tameofthrones.GoldenThronePrinter;
import com.geektrust.tameofthrones.MessageValidator;
import com.geektrust.tameofthrones.RulerPrinter;
import com.geektrust.tameofthrones.SoutherosRuler;

public class TameOfThronesProblem2Starter {

	public static void main(String[] args) {
		MessageValidator messageValidator = new MessageValidator();
		RulerPrinter rulerPrinter = new BreakerOfChainsPrinter();
		List<String> contestantList = new ArrayList<>();
		contestantList.add(EmblemEnum.ICE.toString());
		contestantList.add(EmblemEnum.LAND.toString());
		contestantList.add(EmblemEnum.AIR.toString());
		SoutherosRuler southerosRuler = new BreakerOfChains(contestantList, rulerPrinter, messageValidator);
		southerosRuler.findRulerOfSoutheros();
	}
}
