package fr.syzonia.syzodb.shop.mount;

import java.util.ArrayList;

import java.util.List;
import java.util.UUID;

import org.bukkit.entity.Player;

import fr.syzonia.syzodb.mysql.SQL.SQL;


public class Mountdata {

	public static void addMount(int id, UUID uuid) {
		Object cache = SQL.SQL_Receive("SELECT uuid FROM monture WHERE uuid = '" + uuid.toString() + "'", "uuid");
		if(cache != null) {
			String ids  =(String) SQL.SQL_Receive("SELECT montures FROM monture WHERE uuid = '" + uuid.toString() + "'" , "montures");
			SQL.SQL_Update("UPDATE monture SET montures = '" + ids + id + ";" + "' WHERE uuid = '" + uuid.toString() + "'");
		} else {
			SQL.SQL_Update("INSERT INTO monture (uuid, montures) VALUE ('" + uuid.toString() + "', '" + id + ";')");
		}
	}
	
	public static boolean haveMount(int id, Player player) {
		String ids = "-1";
		String r  =(String) SQL.SQL_Receive("SELECT montures FROM monture WHERE uuid = '" + player.getUniqueId().toString() + "'" , "montures");
		if(r != null) ids = r;
		List<Integer> mounts = new ArrayList<>();
		for (String iD : ids.split(";")) mounts.add(Integer.parseInt(iD));
		boolean haveMount = mounts.contains(id);
		return haveMount;
		
	}
	
}

