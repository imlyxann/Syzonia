package fr.syzonia.hub.VirtualShop.Particules;

import org.bukkit.entity.Player;



import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import fr.syzonia.core.price.PriceUtils;
import fr.syzonia.syzodb.mysql.PlayerInfo;
import fr.syzonia.syzodb.shop.particules.ParticulesData;
import fr.syzonia.hub.VirtualMenu.VirtualMenu;
import fr.syzonia.hub.item.shop.particules.LoadItemShopParticules;

public class ParticulesShop extends VirtualMenu implements Listener{

	public ParticulesShop() {
		super("§dShop > Particules", 9 * 1);
	}
	
	public void open(Player player) {
		new LoadItemShopParticules().LoadItem(this, player);
		OpenInventory(player);
	}
	
	@EventHandler
	public void PlayerInv(InventoryClickEvent event) {
		if(event.getCurrentItem() == null && event.getAction() != null) return;
		
		if(event.getInventory().getName() == "§dShop > Particules") {
			event.setCancelled(true);
			
			Player player = (Player) event.getWhoClicked();
			PlayerInfo playerinfo = PlayerInfo.getInfos(player.getUniqueId());
			ParticulesShop particulesShop = new ParticulesShop();
			
			switch (event.getCurrentItem().getType()) {
			
			case FIREBALL:
				
				if(!ParticulesData.haveParticules(1, player)) {
					if(playerinfo.getCoinsNumber() >= new PriceUtils().Price(130)) {
						playerinfo.removeCoins(new PriceUtils().Price(130));
						ParticulesData.addParticules(1, player.getUniqueId());
					}  else {
						player.sendMessage("§cTu n'as pas assez de SyzoCoins!");
					}
				}
					
					break;
			
			case FURNACE:
				
				if(!ParticulesData.haveParticules(2, player)) {
					if(playerinfo.getCoinsNumber() >= new PriceUtils().Price(140)) {
						playerinfo.removeCoins(new PriceUtils().Price(140));
						ParticulesData.addParticules(2, player.getUniqueId());
					} else {
						player.sendMessage("§cTu n'as pas assez de SyzoCoins!");
					}
				}
				
				break;
				
				case INK_SACK:		
					
					if(!ParticulesData.haveParticules(3, player)) {
						if(playerinfo.getCoinsNumber() >= new PriceUtils().Price(180)) {
							playerinfo.removeCoins(new PriceUtils().Price(180));
							ParticulesData.addParticules(3, player.getUniqueId());
						} else {
							player.sendMessage("§cTu n'as pas assez de SyzoCoins!");
						}
					}
					
					break;
				
				case NETHER_STAR: 
					
					if(!ParticulesData.haveParticules(4, player)) {
						if(playerinfo.getCoinsNumber() >= new PriceUtils().Price(200)) {
							playerinfo.removeCoins(new PriceUtils().Price(2000));
							ParticulesData.addParticules(4, player.getUniqueId());
						} else {
							player.sendMessage("§cTu n'as pas assez de SyzoCoins!");
						}
					}
					
					break;			
			default:
				break;
			}
			
			particulesShop.open(player);
		}
	}

	
	
}
