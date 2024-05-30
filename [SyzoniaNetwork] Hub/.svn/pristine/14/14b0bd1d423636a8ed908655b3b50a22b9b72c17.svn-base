package fr.syzonia.hub.listeners.gameplay;

import org.bukkit.event.EventHandler;

import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;

public class PlayerSuccesListener implements Listener {

	@EventHandler
	public void PlayerSucces(PlayerAchievementAwardedEvent event) {
		event.setCancelled(true);
	}
	
	@EventHandler
	public void BlockBreak(BlockBreakEvent event) {
		event.setCancelled(true);
	}
	
	@EventHandler
	public void BlockPlace(BlockPlaceEvent event) {
		event.setCancelled(true);
	}
	

	@EventHandler
	public void Food(FoodLevelChangeEvent event) {
		event.setCancelled(true);
	}
	
}
