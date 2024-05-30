package fr.syzonia.syzodb.utils;

public class LootBoxUtils {
	
	
	public static String getLootBoxWithHisId(int id) {
		switch (id) {
		case 1:
			
			return "Rare";
			
		case 2:
			
			return "Épique";
			
		case 3:
			
			return "Mythique";
			
		default:
			break;
		}
		
		return null;
	}

	public static String getLootBoxWithHisIdWithString(String id) {
		switch (id) {
		case "1":
			
			return "Rare";
			
		case "2":
			
			return "Epique";
			
		case "3":
			
			return "Mythique";
			
		default:
			break;
		}
		
		return null;
	}
	
}
