package fr.syzonia.syzodb.shop.gadgets;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.entity.Player;

import fr.syzonia.syzodb.mysql.SQL.SQL;

public class GadgetsData {

	public static void addGagdet(int id, UUID uuid) {
		Object cache = SQL.SQL_Receive("SELECT uuid FROM gadgets WHERE uuid = '" + uuid.toString() + "'", "uuid");
		if(cache != null) {
			String ids  =(String) SQL.SQL_Receive("SELECT gadget FROM gadgets WHERE uuid = '" + uuid.toString() + "'" , "gadget");
			SQL.SQL_Update("UPDATE gadgets SET gadget = '" + ids + id + ";" + "' WHERE uuid = '" + uuid.toString() + "'");
		} else {
			SQL.SQL_Update("INSERT INTO gadgets (uuid, gadget) VALUE ('" + uuid.toString() + "', '" + id + ";')");
		}
	}

	public static boolean haveGadget(int id, Player player) {
		String ids = "-1";
		String r  =(String) SQL.SQL_Receive("SELECT gadget FROM gadgets WHERE uuid = '" + player.getUniqueId().toString() + "'" , "gadget");
		if(r != null) ids = r;
		List<Integer> mounts = new ArrayList<>();
		for (String iD : ids.split(";")) mounts.add(Integer.parseInt(iD));
		boolean haveMount = mounts.contains(id);
		return haveMount;
	}
	
}
