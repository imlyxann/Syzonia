package fr.syzonia.hub.VirtualProfil.Particules;

import org.bukkit.entity.Player;



import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.syzonia.syzodb.mysql.particules.UseParticules;
import fr.syzonia.syzodb.shop.particules.ParticulesData;
import fr.syzonia.hub.VirtualMenu.VirtualMenu;
import fr.syzonia.hub.item.Profil.Particules.LoadItemParticulesProfil;

public class VirtualProfilParticules extends VirtualMenu implements Listener{


	public VirtualProfilParticules() {
		super("§6Profil > Particules", 9 * 1);
	}
	
	public void open(Player player) {
		new LoadItemParticulesProfil().LoadItem(this, player);
		OpenInventory(player);
	}
	
	@EventHandler
	public void PlayerInv(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		Inventory inv = event.getInventory();
		ItemStack item = event.getCurrentItem();
		
		if(event.getCurrentItem() == null && event.getAction() != null) return;
		
		if(inv.getName() == "§6Profil > Particules") {
			
			switch (item.getType()) {
			case FIREBALL:

				if(ParticulesData.haveParticules(1, player)) {	
					new UseParticules().setParticulesUse(player.getUniqueId(), 1);
					player.closeInventory();
				} else {
					player.sendMessage("§cTu n'as pas cette particule!");
				}
				
				break;
				
			case FURNACE:
				
				if(ParticulesData.haveParticules(2, player)) {
					new UseParticules().setParticulesUse(player.getUniqueId(), 2);
					player.closeInventory();
				} else {
					player.sendMessage("§cTu n'as pas cette particule!");
				}				
				

			
				break;
				
			case INK_SACK:
				
				if(ParticulesData.haveParticules(3, player)) {
					new UseParticules().setParticulesUse(player.getUniqueId(), 3);
					player.closeInventory();
				} else {
					player.sendMessage("§cTu n'as pas cette particule!");
				}

				
				break;

			case NETHER_STAR:
				
				if(ParticulesData.haveParticules(4, player)) {
					new UseParticules().setParticulesUse(player.getUniqueId(), 4);
					player.closeInventory();
				} else {
					player.sendMessage("§cTu n'as pas cette particule!");
				}

				
				break;
				
			case BLAZE_POWDER:
				
				new UseParticules().setParticulesUse(player.getUniqueId(), 0);
					player.closeInventory();
				
				break;
				
			default:
				break;
			}
		}
	}

	
	
}