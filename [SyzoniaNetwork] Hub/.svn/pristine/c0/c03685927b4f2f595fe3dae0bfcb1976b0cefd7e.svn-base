package fr.syzonia.hub.listeners.gameplay;

import org.bukkit.entity.ArmorStand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class PlayerInteractEvent implements Listener{

	@EventHandler
	public void OnClick(PlayerInteractAtEntityEvent event) {
		if(event.getRightClicked() instanceof ArmorStand) {
			event.setCancelled(true);
		}
	}
	
}
