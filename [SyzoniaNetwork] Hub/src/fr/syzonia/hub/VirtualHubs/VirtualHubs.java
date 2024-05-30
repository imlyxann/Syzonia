package fr.syzonia.hub.VirtualHubs;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import fr.syzonia.core.server.ServerComponent;
import fr.syzonia.hub.VirtualMenu.VirtualMenu;
import fr.syzonia.hub.item.hubs.LoadItemHubs;
import fr.syzonia.syzodb.mysql.ServerName;
import fr.syzonia.syzodb.mysql.hub.HubManager;

public class VirtualHubs extends VirtualMenu implements Listener{

	
	public VirtualHubs() {
		super("§dMenu Des Téléportations", 9 * 1);
	}
	
	public void open(Player player) {
		new LoadItemHubs().LoadItem(this);
		OpenInventory(player);
	}

	@EventHandler
	public void PlayerInv(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		Inventory inv = event.getInventory();
		
		if(event.getCurrentItem() == null && event.getAction() != null) return;
		
		if(inv.getName().equalsIgnoreCase("§dMenu Des Téléportations")) {
			switch (event.getCurrentItem().getType()) {
			case CACTUS:
					
				String name = event.getCurrentItem().getItemMeta().getDisplayName().substring(4);
				
				if(name.equals(ServerName.getServerName(player.getUniqueId()))) {
					player.sendMessage("§cTu es déjà dans ce hub! :c");
					return;
				}
				
				if(new HubManager().getHubPlayers(name) >= 250) {
					player.sendMessage("§cCe Hub me semble rempli :c");
					return;
				}
				
				ServerComponent.MoveToServer(player, name);
				
				break;

			default:
				break;
			}
		}
	}
	
}
