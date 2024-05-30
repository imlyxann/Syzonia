package fr.syzonia.syzodb.shop.pets;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.entity.Player;

import fr.syzonia.syzodb.mysql.SQL.SQL;

public class PetsData {

	public static void addPet(int id, UUID uuid) {
		Object cache = SQL.SQL_Receive("SELECT uuid FROM pet WHERE uuid = '" + uuid.toString() + "'", "uuid");
		if(cache != null) {
			String ids  = (String) SQL.SQL_Receive("SELECT pets FROM pet WHERE uuid = '" + uuid.toString() + "'" , "pets");
			SQL.SQL_Update("UPDATE pet SET pets = '" + ids + id + ";" + "' WHERE uuid = '" + uuid.toString() + "'");
		} else {
			SQL.SQL_Update("INSERT INTO pet (uuid, pets) VALUE ('" + uuid.toString() + "', '" + id + ";')");
		}
	}
	
	public static boolean havePet(int id, Player player) {
		String ids = "-1";
		String r  =(String) SQL.SQL_Receive("SELECT pets FROM pet WHERE uuid = '" + player.getUniqueId().toString() + "'" , "pets");
		if(r != null) ids = r;
		List<Integer> pet = new ArrayList<>();
		for (String iD : ids.split(";")) pet.add(Integer.parseInt(iD));
		boolean havePet = pet.contains(id);
		return havePet;
		
	}
	
}
