package fr.syzonia.hub.VirtualShop.Mounts;

import org.bukkit.entity.Player;



import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import fr.syzonia.core.price.PriceUtils;
import fr.syzonia.syzodb.mysql.PlayerInfo;
import fr.syzonia.syzodb.shop.mount.Mountdata;
import fr.syzonia.hub.VirtualMenu.VirtualMenu;
import fr.syzonia.hub.item.shop.mount.LoadMountShopItem;


public class MountShop extends VirtualMenu implements Listener{

	public MountShop() {
		super("§dShop > Montures",  9 * 1);
	}
	
	public void open(Player player) {
		new LoadMountShopItem().LoadItem(this, player);
		OpenInventory(player);
	}
	
	

	@EventHandler
	public void PlayerInv(InventoryClickEvent event) {
		if(event.getCurrentItem() == null && event.getAction() != null) return;
		
		if(event.getInventory().getName() == "§dShop > Montures") {
			event.setCancelled(true);
			
			Player player = (Player) event.getWhoClicked();
			PlayerInfo playerinfo = PlayerInfo.getInfos(player.getUniqueId());
			MountShop mountshop = new MountShop();
			
			switch (event.getCurrentItem().getType()) {
			
			case BONE:
				
				if(!Mountdata.haveMount(95, player)) {
					if(playerinfo.getCoinsNumber() >= new PriceUtils().Price(120)) {
						playerinfo.removeCoins(new PriceUtils().Price(120));
						Mountdata.addMount(95, player.getUniqueId());
					} else {
						player.sendMessage("§cTu n'as pas assez de SyzoCoins!");
					}
				}
				
				break;
				
			case WHEAT:
				
				if(!Mountdata.haveMount(92, player)) {
					if(playerinfo.getCoinsNumber() >= new PriceUtils().Price(140)) {
						playerinfo.removeCoins(new PriceUtils().Price(140));
						Mountdata.addMount(92, player.getUniqueId());
					} else {
						player.sendMessage("§cTu n'as pas assez de SyzoCoins!");
					}
						
				}
					
					break;
				
				case CARROT_ITEM:				
					if(!Mountdata.haveMount(90, player)) {
						if(playerinfo.getCoinsNumber() >= new PriceUtils().Price(170)) {
							playerinfo.removeCoins(new PriceUtils().Price(170));
							Mountdata.addMount(90, player.getUniqueId());
						} else {
							player.sendMessage("§cTu n'as pas assez de SyzoCoins!");
						}
					}
					
					break;
				
				case WOOL: 
					
					if(!Mountdata.haveMount(91, player)) {
						if(playerinfo.getCoinsNumber() >= new PriceUtils().Price(200)) {
							playerinfo.removeCoins(new PriceUtils().Price(200));
							Mountdata.addMount(91, player.getUniqueId());
						} else {
							player.sendMessage("§cTu n'as pas assez de SyzoCoins!");
						}
					} 
					
					break;			
			default:
				break;
			}
			
			mountshop.open(player);
		}
		
		
		
	}
	
}
