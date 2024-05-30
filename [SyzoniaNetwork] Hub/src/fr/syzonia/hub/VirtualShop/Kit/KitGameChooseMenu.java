package fr.syzonia.hub.VirtualShop.Kit;

import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import fr.syzonia.hub.VirtualMenu.VirtualMenu;
import fr.syzonia.hub.VirtualShop.Kit.CakeWars.KitCakeWarsShop;
import fr.syzonia.hub.item.shop.kits.LoadItemKitsGameChoose;

public class KitGameChooseMenu extends VirtualMenu implements Listener{

	public KitGameChooseMenu() {
		super("§dShop > Kits > Jeux", 9 * 1);
	}
	
	public void open(Player player) {
		new LoadItemKitsGameChoose().LoadItem(this);
		OpenInventory(player);
	}
	
	@EventHandler
	public void PlayerInv(InventoryClickEvent event) {
		if(event.getCurrentItem() == null && event.getAction() != null) return;
		
		if(event.getInventory().getName() == "§dShop > Kits > Jeux") {
			event.setCancelled(true);
		
			Player player = (Player) event.getWhoClicked();
			
			switch (event.getCurrentItem().getType()) {
			case CAKE:
				
				new KitCakeWarsShop().open(player);
				
				break;

			default:
				break;
			}
			
		}
		
	}
	

}
