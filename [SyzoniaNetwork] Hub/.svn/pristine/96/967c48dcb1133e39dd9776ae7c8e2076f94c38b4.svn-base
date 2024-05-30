package fr.syzonia.hub.VirtualProfil.pets;

import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import fr.syzonia.syzodb.mysql.pet.UsePet;
import fr.syzonia.syzodb.shop.pets.PetsData;
import fr.syzonia.hub.VirtualMenu.VirtualMenu;
import fr.syzonia.hub.item.Profil.pets.LoadItemPetsProfil;
import fr.syzonia.hub.pets.PetsManager;

public class VirtualProfilPets extends VirtualMenu implements Listener{

	public VirtualProfilPets() {
		super("§6Profil > Pets", 9 * 1);
	}
	
	public void open(Player player) {
		new LoadItemPetsProfil().LoadItem(this, player);
		OpenInventory(player);
	}
	
	@EventHandler
	public void PlayerInv(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		ItemStack item = event.getCurrentItem();
		
		
		if(item == null && event.getAction() != null) return;
		
		if(event.getInventory().getName() == "§6Profil > Pets") {
			
			switch (item.getType()) {
			case SKULL_ITEM:
				
				if(PetsData.havePet(1, player)) {
					checkPet(player);
					new UsePet().setPetInUse(player.getUniqueId(), 1);
					new PetsManager().spawnMiniPet(player);
					player.closeInventory();
				} else {
					player.closeInventory();
					player.sendMessage("§cVous ne possédez pas cet objet!");
				}
				
				break;
				
			case DIAMOND:
				
				if(PetsData.havePet(2, player)) {
					checkPet(player);
					new UsePet().setPetInUse(player.getUniqueId(), 2);
					new PetsManager().spawnMiniDiamond(player);
					player.closeInventory();
				} else {
					player.closeInventory();
					player.sendMessage("§cVous ne possédez pas cet objet!");
				}
				
				break;
				
			case BLAZE_POWDER:
						
					switch (new UsePet().getPetInUse(player.getUniqueId())) {
					case 1:
						
						new PetsManager().killMiniPet(player);
						player.closeInventory();  
						
						break;

					case 2:
						
						new PetsManager().killMiniDiamond(player);
						player.closeInventory();  
						
						break;
						default:
							break;
						}
					
					new UsePet().setPetInUse(player.getUniqueId(), 0);
					
					
				default:
					break;
					}
				}
			}
		

	public void checkPet(Player player) {
		if(new UsePet().getPetInUse(player.getUniqueId()) > 0) {
			switch (new UsePet().getPetInUse(player.getUniqueId())) {
			case 1:
				
				new PetsManager().killMiniPet(player);
				
				break;

			case 2:
				
				new PetsManager().killMiniDiamond(player);
				
				break;
				default:
					break;
				}
		}
	}
}