package fr.syzonia.hub.game;

import org.bukkit.entity.Player;

import fr.syzonia.core.server.ServerComponent;
import fr.syzonia.syzodb.game.ServerGameStatus;
import fr.syzonia.syzodb.mysql.game.CakeWarsGameManager;

public class GameUtils {

	public static boolean isInBeta(String game) {
		if(game.equalsIgnoreCase("CakeWars")) {
			return false;
		} else if(game.equalsIgnoreCase("Loup-Garou")) {
			return true;
		} else if(game.equalsIgnoreCase("SkyBattle")) {
			return true;
		}
		return false;
	}
	
	public static boolean isInVip(String game) {
		if(game.equalsIgnoreCase("CakeWars")) {
			return true;
		} else if(game.equalsIgnoreCase("Loup-Garou")) {
			return true;
		} else if(game.equalsIgnoreCase("SkyBattle")) {
			return true;
		}
		return false;
	}
	
	public static boolean isAccessible(String gamename, String severname) {
		switch (gamename) {
		case "CakeWars":
			
			CakeWarsGameManager game = new CakeWarsGameManager();
			
			if(game.getStatus(severname).equals(ServerGameStatus.LIGNE.toString()))  {
				return true;
			}
			
			return false;
			
		default:
			break;
		}
		return false;
	}
	
	public static void sendToServer(Player player, String servername) {
		player.sendMessage("§7Vous êtes envoyé sur §6" + servername);
		ServerComponent.MoveToServer(player, servername);
	}
	
}
