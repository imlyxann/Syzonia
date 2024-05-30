package fr.syzonia.hub.VirtualProfil;

import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import fr.syzonia.hub.VirtualMenu.VirtualMenu;
import fr.syzonia.hub.VirtualProfil.Gadgets.VirtualProfilGadgets;
import fr.syzonia.hub.VirtualProfil.Lootboxs.VirtualLootBoxProfil;
import fr.syzonia.hub.VirtualProfil.Mount.VirtualProfilMount;
import fr.syzonia.hub.VirtualProfil.Particules.VirtualProfilParticules;
import fr.syzonia.hub.VirtualProfil.pets.VirtualProfilPets;
import fr.syzonia.hub.VirtualProfil.vetements.ChapeauxProfil;
import fr.syzonia.hub.VirtualProfil.vetements.ChaussuresProfil;
import fr.syzonia.hub.VirtualProfil.vetements.PantalonProfil;
import fr.syzonia.hub.VirtualProfil.vetements.PullProfil;
import fr.syzonia.hub.item.Profil.LoadItemMainMenuProfil;

public class VirtualProfilMain extends VirtualMenu implements Listener{

	public VirtualProfilMain() {
		super("§6Profil", 9 * 6);
	}
	
	public void open(Player player) {
		new LoadItemMainMenuProfil().LoadItem(this);
		OpenInventory(player);
	}

	@EventHandler
	public void PlayerInv(InventoryClickEvent event) {
		if(event.getCurrentItem() == null && event.getAction() != null) return;
		
		if(event.getInventory().getName().equalsIgnoreCase("§6Profil")) {
			event.setCancelled(true);
			
			
			Player player = (Player) event.getWhoClicked();
			
			switch (event.getCurrentItem().getType()) {
			case SADDLE:
				
				new VirtualProfilMount().open(player);
				
				break;
				
			case MAGMA_CREAM:
				
				new VirtualProfilParticules().open(player);
				
				break;

			case DRAGON_EGG:
				
				new VirtualProfilPets().open(player);
				
				break;
				
				
			case PISTON_BASE:
				
				new VirtualProfilGadgets().open(player);
				
				break;
				
			case LEATHER_HELMET:
				
				new ChapeauxProfil().open(player);
				
				break;
				
			case LEATHER_CHESTPLATE:
				
				new PullProfil().open(player);
				
				break;
				
			case LEATHER_LEGGINGS:
				
				new PantalonProfil().open(player);
				
				break;
				
			case LEATHER_BOOTS:
				
				new ChaussuresProfil().open(player);
				
				break;
				
			case ENDER_CHEST:
				
				new VirtualLootBoxProfil().open(player);
				
				break;
				
				
			default:
				break;
			}
			
		}
	}
	
	
	
}
