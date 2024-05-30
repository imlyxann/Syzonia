package fr.syzonia.syzodb.shop.particules;

import java.util.ArrayList;

import java.util.List;
import java.util.UUID;

import org.bukkit.entity.Player;

import fr.syzonia.syzodb.mysql.SQL.SQL;


public class ParticulesData {

	public static void addParticules(int id, UUID uuid) {
		Object cache = SQL.SQL_Receive("SELECT uuid FROM particule WHERE uuid = '" + uuid.toString() + "'", "uuid");
		if(cache != null) {
			String ids  =(String) SQL.SQL_Receive("SELECT particules FROM particule WHERE uuid = '" + uuid.toString() + "'" , "particules");
			SQL.SQL_Update("UPDATE particule SET particules = '" + ids + id + ";" + "' WHERE uuid = '" + uuid.toString() + "'");
		} else {
			SQL.SQL_Update("INSERT INTO particule (uuid, particules) VALUE ('" + uuid.toString() + "', '" + id + ";')");
		}
	}

	public static boolean haveParticules(int id, Player player) {
		String ids = "-1";
		String r  =(String) SQL.SQL_Receive("SELECT particules FROM particule WHERE uuid = '" + player.getUniqueId().toString() + "'" , "particules");
		if(r != null) ids = r;
		List<Integer> mounts = new ArrayList<>();
		for (String iD : ids.split(";")) mounts.add(Integer.parseInt(iD));
		boolean haveMount = mounts.contains(id);
		return haveMount;
	}
	
}
