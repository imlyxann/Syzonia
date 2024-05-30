package fr.syzonia.hub.VirtualShop.Gadgets;

import org.bukkit.entity.Player;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import fr.syzonia.core.price.PriceUtils;
import fr.syzonia.syzodb.mysql.PlayerInfo;
import fr.syzonia.syzodb.shop.gadgets.GadgetsData;
import fr.syzonia.hub.VirtualMenu.VirtualMenu;
import fr.syzonia.hub.item.shop.gadgets.LoadItemShopGadgets;

public class GadgetsShop extends VirtualMenu implements Listener {

	public GadgetsShop() {
		super("§dShop > Gadgets", 9 * 1);
	}

	public void Open(Player player) {
		new LoadItemShopGadgets().load(this, player);
		OpenInventory(player);
	}
	
	@EventHandler
	public void PlayerInv(InventoryClickEvent event) {
		if(event.getCurrentItem() == null && event.getAction() != null) return;

		if(event.getInventory().getName() == "§dShop > Gadgets") {
			event.setCancelled(true);
			
			Player player = (Player) event.getWhoClicked();
			PlayerInfo playerinfo = PlayerInfo.getInfos(player.getUniqueId());
			GadgetsShop gadgetsShop = new GadgetsShop();
			
			switch (event.getCurrentItem().getType()) {
			case JUKEBOX:
				
				if(!GadgetsData.haveGadget(1, player)) {
					if(playerinfo.getCoinsNumber() >= new PriceUtils().Price(280)) {
						playerinfo.removeCoins(new PriceUtils().Price(280));
						GadgetsData.addGagdet(1, player.getUniqueId());
					} else {
						player.sendMessage("§cVous avez pas assez de Syzocoins");
					}
				}
				break;

			default:
				break;
			}
			
			gadgetsShop.Open(player);
		}
	}
	
	
}
