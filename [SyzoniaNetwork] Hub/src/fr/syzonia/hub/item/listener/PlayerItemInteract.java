package fr.syzonia.hub.item.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import fr.syzonia.core.title.Title;
import fr.syzonia.syzodb.mysql.queue.QueueManager;
import fr.syzonia.hub.VirtualHubs.VirtualHubs;
import fr.syzonia.hub.VirtualMenu.MainMenu.VirtualMainMenu;
import fr.syzonia.hub.VirtualProfil.VirtualProfilMain;
import fr.syzonia.hub.VirtualShop.VirtualShopMenu;

public class PlayerItemInteract implements Listener {
	
	@EventHandler
	public void PlayerInteract(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		
		if(event.getItem() == null && event.getAction() != null) return;
		
		switch (event.getItem().getType()) {
		case COMPASS:
			
			if(event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
				new VirtualMainMenu().open(player);
			}
			
			break;
			
		case SKULL_ITEM:
			
			if(event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
				new VirtualProfilMain().open(player);
			}
			
			break;
			
		case NETHER_STAR:
	
			if(event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
				new VirtualShopMenu().open(player);
			}
			
			break;
			
		case COOKIE:
			
			new VirtualHubs().open(player);
			
			break;
			
		case NAME_TAG:
			
			if(event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
				if(new QueueManager().isInQueue(player)) {
					if(player.getInventory().getItem(4) != null) {
						if(event.getItem().getType() == Material.NAME_TAG) {
							new QueueManager().removePlayer(player);
							new Title().sendFullTitle(player, 10, 60, 10, "§cFile d'attente", "Tu as quitté la file d'attente des mini-jeux");
							player.getInventory().setItem(4, null);
						}
					} else {
						player.sendMessage("§cTu ne peux pas faire cette Action!");
					}
		
				}
			}
			
			
			break;

			
		default:
			break;
		}
		
	}
	
}
