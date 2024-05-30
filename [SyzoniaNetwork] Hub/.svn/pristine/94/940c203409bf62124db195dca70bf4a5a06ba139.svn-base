package fr.syzonia.hub.item.hubs;



import org.bukkit.Material;

import fr.syzonia.syzodb.mysql.hub.HubManager;
import fr.syzonia.hub.VirtualMenu.VirtualMenu;
import fr.syzonia.hub.item.ItemBuilder;

public class LoadItemHubs {

	
	public void LoadItem(VirtualMenu menu) {
		for(int x = 1; x <= new HubManager().getAllHubs(); x++) {	
			menu.setItem(x - 1, new ItemBuilder().name("§6§lLobby" + x).type(Material.CACTUS).lore("§aLobby Actif : " + new HubManager().getHubPlayers("Lobby" + x)).build());	
		}
	}
	
}
