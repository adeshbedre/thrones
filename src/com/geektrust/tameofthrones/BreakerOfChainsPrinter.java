package com.geektrust.tameofthrones;

import java.util.List;

public class BreakerOfChainsPrinter implements RulerPrinter {

	@Override
	public void printRuler(String ruler, List<String> alliesList) {
		System.out.println("Who is the ruler of Southeros?");
		System.out.println(ruler);
		System.out.println("Allies of Ruler?");
		System.out.print(alliesList);
	}

}
