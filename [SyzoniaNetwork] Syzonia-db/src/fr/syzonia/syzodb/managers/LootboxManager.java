package fr.syzonia.syzodb.managers;

import java.util.ArrayList;
import java.util.List;

public class LootboxManager {

	public static String ListToSerilization(List<String> lootboxs) {
		String ids = "";
		
		for(String id : lootboxs) {
			ids += id + ";";
		}
		
		return ids;
	}
	
	public static List<String> SerilizationToList(String text) {
		List<String> lootboxs = new ArrayList<String>();
		
		for(String id : text.split(";")) {
			lootboxs.add(id);
		}
		
		return lootboxs;
	}

	
}
