package com.geektrust.tameofthrones;

import java.util.List;

import com.geektrust.tameofthrones.constants.TameOfThronesConstants;

public class OutputService {

	public void printGoldenThroneWinner(List<String> alliesList) {
		System.out.println("Who is the ruler of Southeros?");
		if (alliesList.size() < TameOfThronesConstants.MIN_RULER_COUNT) {
			System.out.println("None");
		} else {
			System.out.println("King Shan");
		}

		System.out.println("Allies of Ruler?");
		if (alliesList.size() < TameOfThronesConstants.MIN_RULER_COUNT) {
			System.out.println("None");
		} else {
			System.out.print(alliesList);
		}
	}

	public void printBreakerOfChainsWinner(String ruler, List<String> alliesList) {
		System.out.println("Who is the ruler of Southeros?");
		System.out.println(ruler);
		System.out.println("Allies of Ruler?");
		System.out.print(alliesList);
	}
}
