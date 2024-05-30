package fr.syzonia.hub.VirtualProfil.Mount;

import org.bukkit.entity.Player;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.syzonia.syzodb.shop.mount.Mountdata;
import fr.syzonia.hub.Mount.MountManager;
import fr.syzonia.hub.VirtualMenu.VirtualMenu;
import fr.syzonia.hub.item.Profil.Mount.LoadItemMountProfil;

public class VirtualProfilMount extends VirtualMenu implements Listener{


	public VirtualProfilMount() {
		super("§6Profil > Montures", 9 * 1);
		
	}
	
	public void open(Player player) {
		new LoadItemMountProfil().LoadItem(this, player);
		OpenInventory(player);
	}
	
	@EventHandler
	public void PlayerInv(InventoryClickEvent event) {
			Player player = (Player) event.getWhoClicked();
			Inventory inv = event.getInventory();
			ItemStack item = event.getCurrentItem();
			
			if(event.getCurrentItem() == null && event.getAction() != null) return;
			
			if(inv.getName() == "§6Profil > Montures") {
				
				switch (item.getType()) {
				case WHEAT:

					if(Mountdata.haveMount(92, player)) {	
						MountManager.rideCow(player);
						player.closeInventory();
					} else {
						player.sendMessage("§cTu n'as pas cette monture!");
					}
					
					break;
					
				case BONE:
					
					if(Mountdata.haveMount(95, player)) {
						MountManager.rideWolf(player);	
						player.closeInventory();
					} else {
						player.sendMessage("§cTu n'as pas cette monture!");
					}				
					

				
					break;
					
				case CARROT_ITEM:
					
					if(Mountdata.haveMount(90, player)) {
						MountManager.ridePig(player);
						player.closeInventory();
					} else {
						player.sendMessage("§cTu n'as pas cette monture!");
					}

					
					break;

				case WOOL:
					
					if(Mountdata.haveMount(91, player)) {
						MountManager.rideSheep(player);
						player.closeInventory();
					} else {
						player.sendMessage("§cTu n'as pas cette monture!");
					}

					
					break;
					
				default:
					break;
				}
				
			}
			
	}

	
	
}