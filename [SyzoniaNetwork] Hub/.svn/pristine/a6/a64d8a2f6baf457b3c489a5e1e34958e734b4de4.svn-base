package fr.syzonia.hub.VirtualMenu.minigames;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import fr.syzonia.hub.VirtualGame.cakewars.VirtualGameCakeWars;
import fr.syzonia.hub.VirtualMenu.VirtualMenu;
import fr.syzonia.hub.item.minigames.LoadItemMiniGamesMenu;

public class VirtualMiniGamesMenu extends VirtualMenu implements Listener{

	public VirtualMiniGamesMenu() {
		super("§aMini-Jeux", 9 * 6);
	}

	public void open(Player player) {
		new LoadItemMiniGamesMenu().LoadItem(this);
		OpenInventory(player);
	}
	
	@EventHandler
	public void PlayerClickInv(InventoryClickEvent event) {
		if(event.getCurrentItem() == null && event.getAction() != null) return;
		
		Player player = (Player) event.getWhoClicked();
		Inventory inv = event.getInventory();
		
		if(inv.getName().equalsIgnoreCase("§aMini-Jeux")) {
			event.setCancelled(true);
			
			switch (event.getCurrentItem().getType()) {
			case CAKE:
				
				new VirtualGameCakeWars().Open(player);
				
				break;
				
			case NETHER_STAR:
				
				player.closeInventory();
				player.sendMessage("§cPlus tard...");
				
				break;
				
			case GOLDEN_APPLE:
				
				player.closeInventory();
				player.sendMessage("§cPlus tard...");
				
				break;
				

			default:
				break;
			}
			
		}
	}
	
	
	
}
