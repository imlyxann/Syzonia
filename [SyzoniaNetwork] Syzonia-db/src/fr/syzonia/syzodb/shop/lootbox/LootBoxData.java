package fr.syzonia.syzodb.shop.lootbox;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.entity.Player;

import fr.syzonia.syzodb.managers.LootboxManager;
import fr.syzonia.syzodb.mysql.SQL.SQL;
import fr.syzonia.syzodb.utils.LootBoxUtils;

public class LootBoxData {

	public static void addLootBox(int id, UUID uuid) {
		Object cache = SQL.SQL_Receive("SELECT uuid FROM lootbox WHERE uuid = '" + uuid.toString() + "'", "uuid");
		if(cache != null) {
			String ids  = (String) SQL.SQL_Receive("SELECT lootboxs FROM lootbox WHERE uuid = '" + uuid.toString() + "'" , "lootboxs");
			SQL.SQL_Update("UPDATE lootbox SET lootboxs = '" + ids + id + ";" + "' WHERE uuid = '" + uuid.toString() + "'");
		} else {
			SQL.SQL_Update("INSERT INTO lootbox (uuid, lootboxs) VALUE ('" + uuid.toString() + "', '" + id + ";')");
		}
	}
	
	public static void removeLootbox(UUID uuid, int id) {
		Object cache = SQL.SQL_Receive("SELECT uuid FROM lootbox WHERE uuid = '" + uuid.toString() + "'", "uuid");
		if(cache != null) {
			String ids  = (String) SQL.SQL_Receive("SELECT lootboxs FROM lootbox WHERE uuid = '" + uuid.toString() + "'" , "lootboxs");
			List<String> lootboxs = LootboxManager.SerilizationToList(ids);
			lootboxs.remove("" + id);
			ids = LootboxManager.ListToSerilization(lootboxs);
			SQL.SQL_Update("UPDATE lootbox SET lootboxs = '" + ids + "' WHERE uuid = '" + uuid.toString() + "'");
		}
	}
	
	public static boolean haveLootBox(int id, Player player) {
		String ids = "-1";
		String r  =(String) SQL.SQL_Receive("SELECT lootboxs FROM lootbox WHERE uuid = '" + player.getUniqueId().toString() + "'" , "lootboxs");
		if(r != null) ids = r;
		List<Integer> mounts = new ArrayList<>();
		for (String iD : ids.split(";")) mounts.add(Integer.parseInt(iD));
		boolean haveMount = mounts.contains(id);
		return haveMount;
		
	}
	
	public List<String> getLootboxs(UUID uuid) {
		Object cache = SQL.SQL_Receive("SELECT uuid FROM lootbox WHERE uuid = '" + uuid.toString() + "'", "uuid");
		if(cache != null) {
			List<String> lootboxs = new ArrayList<String>();
			String r  =(String) SQL.SQL_Receive("SELECT lootboxs FROM lootbox WHERE uuid = '" + uuid.toString() + "'" , "lootboxs");
			
			for(String id : r.split(";")) {
				lootboxs.add(LootBoxUtils.getLootBoxWithHisIdWithString(id));
			}
			
			return lootboxs;
		}
		return null;
	}
	
	public List<String> getRareLootboxs(UUID uuid) {
		Object cache = SQL.SQL_Receive("SELECT uuid FROM lootbox WHERE uuid = '" + uuid.toString() + "'", "uuid");
		if(cache != null) {
			String r  =(String) SQL.SQL_Receive("SELECT lootboxs FROM lootbox WHERE uuid = '" + uuid.toString() + "'" , "lootboxs");
			List<String> lootboxs = new ArrayList<String>();
			
			for(String id : r.split(";")) {
				if(id.equals("1")) {
					lootboxs.add(LootBoxUtils.getLootBoxWithHisIdWithString(id));
				}
			}
			
			return lootboxs;
		}
		return null;
	}
	
	public List<String> getEpiqueLootboxs(UUID uuid) {
		Object cache = SQL.SQL_Receive("SELECT uuid FROM lootbox WHERE uuid = '" + uuid.toString() + "'", "uuid");
		if(cache != null) {
			String r  =(String) SQL.SQL_Receive("SELECT lootboxs FROM lootbox WHERE uuid = '" + uuid.toString() + "'" , "lootboxs");
			List<String> lootboxs = new ArrayList<String>();
			
			for(String id : r.split(";")) {
				if(id.equals("2")) {
					lootboxs.add(LootBoxUtils.getLootBoxWithHisIdWithString(id));
				}
				
			}
			
			return lootboxs;
		}
		return null;
	} 
	
	public List<String> getMythiqueLootboxs(UUID uuid) {
		Object cache = SQL.SQL_Receive("SELECT uuid FROM lootbox WHERE uuid = '" + uuid.toString() + "'", "uuid");
		if(cache != null) {
			String r  =(String) SQL.SQL_Receive("SELECT lootboxs FROM lootbox WHERE uuid = '" + uuid.toString() + "'" , "lootboxs");
			List<String> lootboxs = new ArrayList<String>();
			
			for(String id : r.split(";")) {
				if(id.equals("3")) {
					lootboxs.add(LootBoxUtils.getLootBoxWithHisIdWithString(id));
				}
			}
			
			return lootboxs;
		}
		return null;
	}
	
	public int getLootboxsValues(UUID uuid) {
		return getLootboxs(uuid).size();
	}
	
	public int getRareLootboxsValues(UUID uuid) {
		return getRareLootboxs(uuid).size();
	}
	
	public int getEpiqueLootboxsValues(UUID uuid) {
		return getEpiqueLootboxs(uuid).size();
	}
	
	public int getMythiqueLootboxsValues(UUID uuid) {
		return getMythiqueLootboxs(uuid).size();
	}
	
	
	
	
}
