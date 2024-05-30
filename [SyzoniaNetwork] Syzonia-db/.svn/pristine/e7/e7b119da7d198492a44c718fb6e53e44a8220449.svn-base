package fr.syzonia.syzodb.shop.vetements;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.entity.Player;

import fr.syzonia.syzodb.mysql.SQL.SQL;

public class VetementsManager {

	public static void addChapeau(int id, UUID uuid) {
		Object cache;
		cache = SQL.SQL_Receive("SELECT uuid FROM vetements WHERE uuid = '" + uuid.toString() + "'", "uuid");
		
		if(cache != null) {
			String ids  =(String) SQL.SQL_Receive("SELECT chapeaux FROM vetements WHERE uuid = '" + uuid.toString() + "'" , "chapeaux");
			if(ids == null) {
				ids = "";
			}
			ids += id + ";";
			SQL.SQL_Update("UPDATE vetements SET chapeaux = '" + ids + "' WHERE uuid = '" + uuid.toString() + "'");
		} else {
			SQL.SQL_Update("INSERT INTO vetements (uuid, chapeaux) VALUE ('" + uuid.toString() + "', '" + id + ";')");
		}
	}

	public static boolean haveChapeau(int id, Player player) {
		String ids = "-1";
		String r  =(String) SQL.SQL_Receive("SELECT chapeaux FROM vetements WHERE uuid = '" + player.getUniqueId().toString() + "'" , "chapeaux");
		if(r != null) ids = r;
		List<Integer> chapeaux = new ArrayList<>();
		for (String iD : ids.split(";")) chapeaux.add(Integer.parseInt(iD));
		boolean have = chapeaux.contains(id);
		return have;
	}
	
	public static void addPull(int id, UUID uuid) {
		Object cache;
		cache = SQL.SQL_Receive("SELECT uuid FROM vetements WHERE uuid = '" + uuid.toString() + "'", "uuid");
		
		if(cache != null) {
			String ids  =(String) SQL.SQL_Receive("SELECT pull FROM vetements WHERE uuid = '" + uuid.toString() + "'" , "pull");
			if(ids == null) {
				ids = "";
			}
			ids += id + ";";
			SQL.SQL_Update("UPDATE vetements SET pull = '" + ids + "' WHERE uuid = '" + uuid.toString() + "'");
		} else {
			SQL.SQL_Update("INSERT INTO vetements (uuid, pull) VALUE ('" + uuid.toString() + "', '" + id + ";')");
		}
	}

	public static boolean havePull(int id, Player player) {
		String ids = "-1";
		String r  =(String) SQL.SQL_Receive("SELECT pull FROM vetements WHERE uuid = '" + player.getUniqueId().toString() + "'" , "pull");
		if(r != null) ids = r;
		List<Integer> pull = new ArrayList<>();
		for (String iD : ids.split(";")) pull.add(Integer.parseInt(iD));
		boolean have = pull.contains(id);
		return have;
	}
	
	public static void addPantalon(int id, UUID uuid) {
		Object cache;
		cache = SQL.SQL_Receive("SELECT uuid FROM vetements WHERE uuid = '" + uuid.toString() + "'", "uuid");
		
		if(cache != null) {
			String ids  =(String) SQL.SQL_Receive("SELECT pantalon FROM vetements WHERE uuid = '" + uuid.toString() + "'" , "pantalon");
			if(ids == null) {
				ids = "";
			}
			ids += id + ";";
			SQL.SQL_Update("UPDATE vetements SET pantalon = '" + ids + "' WHERE uuid = '" + uuid.toString() + "'");
		} else {
			SQL.SQL_Update("INSERT INTO vetements (uuid, pantalon) VALUE ('" + uuid.toString() + "', '" + id + ";')");
		}
	}

	public static boolean havePantalon(int id, Player player) {
		String ids = "-1";
		String r  =(String) SQL.SQL_Receive("SELECT pantalon FROM vetements WHERE uuid = '" + player.getUniqueId().toString() + "'" , "pantalon");
		if(r != null) ids = r;
		List<Integer> pantalon = new ArrayList<>();
		for (String iD : ids.split(";")) pantalon.add(Integer.parseInt(iD));
		boolean have = pantalon.contains(id);
		return have;
	}
	
	public static void addChaussure(int id, UUID uuid) {
		Object cache;
		cache = SQL.SQL_Receive("SELECT uuid FROM vetements WHERE uuid = '" + uuid.toString() + "'", "uuid");
		
		if(cache != null) {
			String ids  =(String) SQL.SQL_Receive("SELECT chaussure FROM vetements WHERE uuid = '" + uuid.toString() + "'" , "chaussure");
			if(ids == null) {
				ids = "";
			}
			ids += id + ";";
			SQL.SQL_Update("UPDATE vetements SET chaussure = '" + ids + "' WHERE uuid = '" + uuid.toString() + "'");
		} else {
			SQL.SQL_Update("INSERT INTO vetements (uuid, chaussure) VALUE ('" + uuid.toString() + "', '" + id + ";')");
		}
	}

	public static boolean haveChaussure(int id, Player player) {
		String ids = "-1";
		String r  =(String) SQL.SQL_Receive("SELECT chaussure FROM vetements WHERE uuid = '" + player.getUniqueId().toString() + "'" , "chaussure");
		if(r != null) ids = r;
		List<Integer> chaussure = new ArrayList<>();
		for (String iD : ids.split(";")) chaussure.add(Integer.parseInt(iD));
		boolean have = chaussure.contains(id);
		return have;
	}
	
}
