package fr.syzonia.hub.VirtualProfil.vetements;

import org.bukkit.Color;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import fr.syzonia.syzodb.mysql.vetements.UseVetements;
import fr.syzonia.syzodb.shop.vetements.VetementsManager;
import fr.syzonia.hub.VirtualMenu.VirtualMenu;
import fr.syzonia.hub.item.ItemBuilder;
import fr.syzonia.hub.item.Profil.vetements.LoadPantalonProfilItem;

public class PantalonProfil extends VirtualMenu implements Listener{

	public PantalonProfil() {
		super("§6Profil > Pantalons", 9 * 1);
	}
	
	public void open(Player player) {
		new LoadPantalonProfilItem().load(this, player);
		OpenInventory(player);
	}
	
	@EventHandler
	public void PlayerInv(InventoryClickEvent event) {
		if(event.getCurrentItem() == null && event.getAction() != null) return;
		
		if(event.getInventory().getName() == "§6Profil > Pantalons") {
			event.setCancelled(true);
			
			Player player = (Player) event.getWhoClicked();
			
			switch (event.getCurrentItem().getType()) {
			case LEATHER_LEGGINGS:
				
				switch (event.getCurrentItem().getItemMeta().getDisplayName()) {
				case "§6Pantalon Nike":
					
					if(VetementsManager.havePantalon(1, player)) {
						new UseVetements().setPantalonUse(event.getWhoClicked().getUniqueId(), 1);
						event.getWhoClicked().getInventory().setLeggings(new ItemBuilder().type(Material.LEATHER_LEGGINGS).setLeatherColor(Color.BLACK).name("§6Pantalon Nike").lore("§6Garde du style !").build());
						player.closeInventory();
					} else {
						player.sendMessage("§cTu n'as pas cet objet");
					}
					
				
				default:
					break;
				}
				
				break;
				
			case BLAZE_ROD:
				
				new UseVetements().setPantalonUse(event.getWhoClicked().getUniqueId(), 0);
				event.getWhoClicked().getInventory().setLeggings(null);
				player.closeInventory();
				
				break;

			default:
				break;
			}
		}
	}

	
	
}
