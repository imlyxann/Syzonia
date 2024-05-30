package fr.syzonia.hub.listeners.gameplay;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class PlayerInventoryDropEvent implements Listener {

	@EventHandler
	public void PlayerDrop(InventoryClickEvent event) {
		event.setCancelled(true);
	}
	
}
