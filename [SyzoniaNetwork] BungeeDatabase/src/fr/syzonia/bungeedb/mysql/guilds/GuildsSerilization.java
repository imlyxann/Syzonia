package fr.syzonia.bungeedb.mysql.guilds;

import java.util.ArrayList;
import java.util.List;

public class GuildsSerilization {

	public static String ListToSerilization(List<String> members) {
		String ids = "";
		
		for(String id : members) {
			ids += id + ";";
		}
		
		return ids;
	}
	
	public static List<String> SerilizationToList(String text) {
		List<String> members = new ArrayList<String>();
		
		for(String id : text.split(";")) {
			members.add(id);
		}
		
		return members;
	}
	
}
