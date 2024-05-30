package fr.syzonia.hub.item.gadget;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import fr.syzonia.syzodb.mysql.gadget.UseGadget;
import fr.syzonia.hub.gadgets.MusiquaGadget;


public class ItemListenerGadgets implements Listener{

	@EventHandler
	public void PlayerInteract(PlayerInteractEvent event) {
		if(event.getItem() == null && event.getAction() != null) return;
		
		if(new UseGadget().getGadgetInUse(event.getPlayer().getUniqueId()) > 0) {
			
			switch (event.getItem().getType()) {
			case JUKEBOX:
			
				if(event.getItem().getItemMeta().getDisplayName() == "§bMusiqua") {
					new MusiquaGadget().Use(event.getPlayer());
				}
				
				break;
				

			default:
				break;
			}	
		}
	}
	
	
	
}
