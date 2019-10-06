package com.geektrust.tameofthrones;

import java.util.List;

import com.geektrust.tameofthrones.constants.TameOfThronesConstants;

public class GoldenThronePrinter implements RulerPrinter {

	@Override
	public void printRuler(String ruler, List<String> alliesList) {
		System.out.println("Who is the ruler of Southeros?");
		if (alliesList.size() < TameOfThronesConstants.MIN_RULER_COUNT) {
			System.out.println("None");
		} else {
			System.out.println(ruler);
		}

		System.out.println("Allies of Ruler?");
		if (alliesList.size() < TameOfThronesConstants.MIN_RULER_COUNT) {
			System.out.println("None");
		} else {
			System.out.print(alliesList);
		}
	}

}
