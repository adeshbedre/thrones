package com.geektrust.tameofthrones;

import com.geektrust.model.SystemEnum;

public class SoutherosRulerFactory {
	
	public static SoutherosRuler rulerChoosingSystem(SystemEnum system) {
		SoutherosRuler southerosRuler = null;
		if(system.equals(SystemEnum.GOLDENTHRONE)) {
			MessageValidator messageValidator = new MessageValidator();
			RulerPrinter rulerPrinter = new GoldenThronePrinter();
//			southerosRuler = new GoldenThrone(messageValidator, rulerPrinter);
		}else if(system.equals(SystemEnum.BREAKEROFCHAINS)) {
			
		}
		return southerosRuler;
	}
}
