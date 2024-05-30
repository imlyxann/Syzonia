package fr.syzonia.hub.VirtualShop.Pets;


import org.bukkit.entity.Player;




import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import fr.syzonia.core.price.PriceUtils;
import fr.syzonia.syzodb.mysql.PlayerInfo;
import fr.syzonia.syzodb.shop.pets.PetsData;
import fr.syzonia.hub.VirtualMenu.VirtualMenu;
import fr.syzonia.hub.item.shop.pets.LoadShopPetsItem;

public class PetsShop extends VirtualMenu implements Listener{

	public PetsShop() {
		super("§dShop > Pets", 9 * 1);
	}
	
	public void open(Player player) {
		new LoadShopPetsItem().LoadItem(this, player);
		OpenInventory(player);
	}
	
	@EventHandler
	public void PlayerInv(InventoryClickEvent event) {
		if(event.getCurrentItem() == null && event.getAction() != null) return;
		
		if(event.getInventory().getName() == "§dShop > Pets") {
			event.setCancelled(true);
			
			Player player = (Player) event.getWhoClicked();
			PlayerInfo playerinfo = PlayerInfo.getInfos(player.getUniqueId());
			PetsShop petsShop = new PetsShop();
			
			switch (event.getCurrentItem().getType()) {
			case SKULL_ITEM:
				
				if(!PetsData.havePet(1, player)) {
					if(playerinfo.getCoinsNumber() >= new PriceUtils().Price(200)) {
						playerinfo.removeCoins(new PriceUtils().Price(200));
						PetsData.addPet(1, player.getUniqueId());
					} else {
						player.sendMessage("§cVous n'avez pas assez de syzocoins");
					}
				}
				
				break;
				
			case DIAMOND:
				
				if(!PetsData.havePet(2, player)) {
					if(playerinfo.getCoinsNumber() >= new PriceUtils().Price(180)) {
						playerinfo.removeCoins(new PriceUtils().Price(180));
						PetsData.addPet(2, player.getUniqueId());
					} else {
						player.sendMessage("§cVous n'avez pas assez de syzocoins");
					}
				}
				
				break;

			default:
				break;
			}
			
			petsShop.open(player);
		}
	}
}
