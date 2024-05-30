package fr.syzonia.syzodb.rank;

import java.util.UUID;

import org.bukkit.Bukkit;

import fr.syzonia.syzodb.mysql.PlayerInfo;
import fr.syzonia.syzodb.mysql.RewardsManager;
import fr.syzonia.syzodb.utils.Symbol;

public class TeamsManager {

	public static void Syzorank(UUID target, int power) {
		PlayerInfo.getInfos(target).setRank(power);
		
		if(power >= 1 && power < 4) {
			if(power == 3) new Symbol().setSymbol(target, 2);
			new RewardsManager().setRewardsFound(target, true);
			sendMessage(target, "§aVous avez des Récompenses, allez vite vous déconnectez puis vous reconnectez!");
		}
		if(new Symbol().getBddSymbol(target) > 0 && new PlayerInfo(target).getRank() != 3) new Symbol().setSymbol(target, 0);
	}
	
	private static void sendMessage(UUID uuid, String msg) {
		if(uuid != null) Bukkit.getPlayer(uuid).sendMessage(msg);
	}
	
}
