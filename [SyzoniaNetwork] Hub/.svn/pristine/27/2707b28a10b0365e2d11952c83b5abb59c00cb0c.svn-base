package fr.syzonia.hub.VirtualProfil.Gadgets;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import fr.syzonia.syzodb.mysql.gadget.UseGadget;
import fr.syzonia.syzodb.mysql.queue.QueueManager;
import fr.syzonia.syzodb.shop.gadgets.GadgetsData;
import fr.syzonia.hub.VirtualMenu.VirtualMenu;
import fr.syzonia.hub.item.ItemBuilder;
import fr.syzonia.hub.item.Profil.Gadgets.LoadItemProfilGadgets;

public class VirtualProfilGadgets extends VirtualMenu implements Listener{

	public VirtualProfilGadgets() {
		super("§6Profil > Gadgets", 9 * 1);
	}
	
	public void open(Player player) {
		new LoadItemProfilGadgets().load(this, player);
		OpenInventory(player);
	}
	
	@EventHandler
	public void PlayerInv(InventoryClickEvent event) {
		if(event.getCurrentItem() == null && event.getAction() != null) return;
		
		if(event.getInventory().getName() == "§6Profil > Gadgets") {
			event.setCancelled(true);
			
			Player player = (Player) event.getWhoClicked();
			
			switch (event.getCurrentItem().getType()) {
			case JUKEBOX:
				
				if(GadgetsData.haveGadget(1, player)) {
					
					if(new QueueManager().isInQueue(player)) {
						player.closeInventory();
						player.sendMessage("§eSYZONIA §6| §cAction Imposssible");
						return;
					}
					
					new UseGadget().setGadgetInUse(player.getUniqueId(), 1);
					player.getInventory().setItem(4, new ItemBuilder().type(Material.JUKEBOX).name("§bMusiqua").lore("§eFais de la musique !!").build());
					player.closeInventory();
					
				} else {
					player.closeInventory();
					player.sendMessage("§cTu ne possède pas ce gadget");
				}
				
				break;
				
			case BLAZE_ROD:
				
				new UseGadget().setGadgetInUse(player.getUniqueId(), 0);
				player.getInventory().setItem(4, new ItemBuilder().type(Material.AIR).build());
				
				player.closeInventory();
				player.sendMessage("§e§lDésactivé!");
				
				break;

			default:
				break;
			}
		}
	}

	
	
}
