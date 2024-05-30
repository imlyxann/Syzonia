package fr.syzonia.syzowolf.listeners.player;

import org.bukkit.entity.Player;



import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.syzonia.syzodb.mysql.BanManager;
import fr.syzonia.syzowolf.Main;
import fr.syzonia.syzowolf.SyzoPlayer;
import fr.syzonia.syzowolf.check.Checker;



public class PlayerListener implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		
		if(new BanManager().isBanned(event.getPlayer().getUniqueId())) {
			return;
		}
		
		Main.SyzoPlayers.put(player, new SyzoPlayer(player));
		
		new Checker().initPlayer(player);
		

	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		
		Player player = event.getPlayer();
		
		if(new BanManager().isBanned(event.getPlayer().getUniqueId())) {
			return;
		}
		
		Main.SyzoPlayers.remove(player);
		
	}
	
	
	
}
