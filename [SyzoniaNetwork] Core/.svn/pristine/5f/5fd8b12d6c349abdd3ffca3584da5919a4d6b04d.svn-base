package fr.syzonia.core.rank;

import org.bukkit.entity.Player;

import fr.syzonia.syzodb.mysql.PlayerInfo;

public class RankUtils {

	
  	public String getPlayerRank(Player player) {
  		double rank = PlayerInfo.getInfos(player.getUniqueId()).getRank();
  		
  		if(rank == 0) {
  			return "§7Joueur";
  		}
  		
  		if(rank == 1) {
  			return "§eVIP";
  		}
  		
  		if(rank == 2) {
  			return "§3VIP+";
  		}
  		
  		if(rank == 3) {
  			return "§3Legend";
  		}
  		
  		if(rank == 4) {
  			return "§fCopaing";
  		}
  		
  		if(rank == 5) {
  			return "§5Mod";
  		}
  		
  		if(rank == 6) {
  			return "§eSuper-Modo";
  		}
  		
  		if(rank == 7) {
  			return "§4Admin";
  		}
  		
  		return "";
	}
	
}
