package fr.syzonia.hub.VirtualShop.Vetements;



import java.util.UUID;



import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import fr.syzonia.core.price.PriceUtils;
import fr.syzonia.syzodb.mysql.PlayerInfo;
import fr.syzonia.syzodb.shop.vetements.VetementsManager;
import fr.syzonia.hub.VirtualMenu.VirtualMenu;
import fr.syzonia.hub.item.shop.vetements.LoadChaussureShopItem;

public class ChaussureShop extends VirtualMenu implements Listener{

	public ChaussureShop() {
		super("§dShop > Chaussures", 9 * 1);
	}

	public void open(Player player) {
		new LoadChaussureShopItem().load(this, player);
		OpenInventory(player);
	}
	
	@EventHandler
	public void PlayerInv(InventoryClickEvent event) {
		if(event.getCurrentItem() == null && event.getAction() != null) return;
		
		if(event.getInventory().getName() == "§dShop > Chaussures") {
			event.setCancelled(true);
			
			Player player = (Player) event.getWhoClicked();
			PlayerInfo playerinfo = PlayerInfo.getInfos(player.getUniqueId());
			UUID uuid = player.getUniqueId();
			ChaussureShop chaussureshop = new ChaussureShop();
			
			switch (event.getCurrentItem().getType()) {
			
			case LEATHER_BOOTS:
				
				switch (event.getSlot()) {
				case 0:
					
					if(!VetementsManager.haveChaussure(1, player)) {
						if(playerinfo.getCoinsNumber() >= new PriceUtils().Price(180)) {
							playerinfo.removeCoins(new PriceUtils().Price(180));
							VetementsManager.addChaussure(1, uuid);
						} else {
							player.sendMessage("§cVous n'avez pas assez de SyzoCoins");
						}
					}
					
					break;

				default:
					break;
				}
				
			break;
				
			default:
				break;
			}
			
			chaussureshop.open(player);
		}
	}
	
}
