package com.geektrust.tameofthrones;

import java.util.ArrayList;
import java.util.List;

import com.geektrust.model.EmblemEnum;
import com.geektrust.model.Kingdom;

public class Kingdoms {

	public static List<Kingdom> fetchAllKingdoms() {
		List<Kingdom> kindomList = new ArrayList<>();
		for (EmblemEnum emblem : EmblemEnum.values()) {
			Kingdom kingdom = new Kingdom(emblem.name(), emblem.getAnimal());
			kindomList.add(kingdom);
		}
		return kindomList;
	}
}
