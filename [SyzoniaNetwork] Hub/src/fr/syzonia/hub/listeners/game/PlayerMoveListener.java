package fr.syzonia.hub.listeners.game;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {
	
	@EventHandler(priority = EventPriority.HIGH)
	public void PlayerMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		
		if(player.getLocation().getY() <= 50) {
			player.teleport(new Location(Bukkit.getWorld("world"), Bukkit.getWorld("world").getSpawnLocation().getX(), Bukkit.getWorld("world").getSpawnLocation().getY(), Bukkit.getWorld("world").getSpawnLocation().getZ()));
		}
	}
	
}
