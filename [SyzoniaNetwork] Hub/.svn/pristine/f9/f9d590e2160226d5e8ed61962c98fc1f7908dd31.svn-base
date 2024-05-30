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
import fr.syzonia.hub.item.Profil.vetements.LoadChapeauxProfilItem;

public class ChapeauxProfil extends VirtualMenu implements Listener{

	public ChapeauxProfil() {
		super("§6Profil > Chapeaux", 9 * 1);
	}
	
	public void open(Player player) {
		new LoadChapeauxProfilItem().load(this, player);
		OpenInventory(player);
	}
	
	@EventHandler
	public void PlayerInv(InventoryClickEvent event) {
		if(event.getCurrentItem() == null && event.getAction() != null) return;
		
		if(event.getInventory().getName() == "§6Profil > Chapeaux") {
			event.setCancelled(true);
			
			Player player = (Player) event.getWhoClicked();
			
			switch (event.getCurrentItem().getType()) {
			case LEATHER_HELMET:
				
				switch (event.getCurrentItem().getItemMeta().getDisplayName()) {
				case "§6Casquette Nike":
					
					
					if(VetementsManager.haveChapeau(1, player)) {
						new UseVetements().setChapeauxInUse(event.getWhoClicked().getUniqueId(), 1);
						event.getWhoClicked().getInventory().setHelmet(new ItemBuilder().type(Material.LEATHER_HELMET).setLeatherColor(Color.BLACK).name("§6Casquette Nike").lore("§6Garde du style !").build());
						player.closeInventory();
					} else {
						player.sendMessage("§cTu n'as pas cet objet");
					}
					

				default:
					break;
				}
				
				break;
				
			case BLAZE_ROD:
				
				new UseVetements().setChapeauxInUse(event.getWhoClicked().getUniqueId(), 0);
				event.getWhoClicked().getInventory().setHelmet(null);
				player.closeInventory();
				
				
				break;

			default:
				break;
			}
		}
	}

	
	
}
