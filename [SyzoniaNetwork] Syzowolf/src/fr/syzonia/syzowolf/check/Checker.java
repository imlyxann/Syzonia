package fr.syzonia.syzowolf.check;

import org.bukkit.entity.Player;

import fr.syzonia.syzowolf.Main;
import fr.syzonia.syzowolf.SyzoPlayer;



public class Checker {

	public void initPlayer(Player player) {
		SyzoPlayer syzoplayer = Main.SyzoPlayers.get(player);
		
		syzoplayer.setLastLocationSpeed(player.getLocation());
		syzoplayer.setLastMove(System.currentTimeMillis());
		
	}
	
}
