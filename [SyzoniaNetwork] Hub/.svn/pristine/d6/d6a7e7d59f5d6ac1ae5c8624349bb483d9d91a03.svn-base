package fr.syzonia.hub.VirtualShop.Kit.CakeWars;

import org.bukkit.entity.Player;



import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import fr.syzonia.core.price.PriceUtils;
import fr.syzonia.syzodb.kits.cakewars.CakeWarsKitsManager;
import fr.syzonia.syzodb.mysql.PlayerInfo;
import fr.syzonia.hub.VirtualMenu.VirtualMenu;
import fr.syzonia.hub.item.shop.kits.cakewars.LoadItemShopKitsCakeWars;

public class KitCakeWarsShop extends VirtualMenu implements Listener{

	public KitCakeWarsShop() {
		super("§dShop > Kits > Jeux > CK", 9 * 1);
	}
	
	public void open(Player player) {
		new LoadItemShopKitsCakeWars().LoadItem(this, player);
		OpenInventory(player);
	}
	
	@EventHandler
	public void PlayerInv(InventoryClickEvent event) {
		if(event.getCurrentItem() == null && event.getAction() != null) return;
		
		if(event.getInventory().getName() == "§dShop > Kits > Jeux > CK") {
			event.setCancelled(true);
			
			Player player = (Player) event.getWhoClicked();
			KitCakeWarsShop ckshop = new KitCakeWarsShop();
			
			switch (event.getCurrentItem().getType()) {
			case IRON_SWORD:
				
				if(CakeWarsKitsManager.Ranger.getPlayerKit(player.getUniqueId()) == 0) {
					 
					if(PlayerInfo.getInfos(player.getUniqueId()).getCoinsNumber() >= new PriceUtils().Price(110)) {						
						CakeWarsKitsManager.Ranger.addKit(player.getUniqueId());
						PlayerInfo.getInfos(player.getUniqueId()).removeCoins(new PriceUtils().Price(110));
						
					} else {
						player.sendMessage("§cTu n'as pas assez de SyzoCoins!");
					}
					
				} 
				
				break;
				
			case WOOL:
				
				if(CakeWarsKitsManager.Gladiator.getPlayerKit(player.getUniqueId()) == 0) {
					 
					if(PlayerInfo.getInfos(player.getUniqueId()).getCoinsNumber() >= new PriceUtils().Price(130)) {	
						CakeWarsKitsManager.Gladiator.addKit(player.getUniqueId());
						PlayerInfo.getInfos(player.getUniqueId()).removeCoins(new PriceUtils().Price(130));
					} else {
						player.sendMessage("§cTu n'as pas assez de SyzoCoins!");
					}
					
				}
				
				break;
				
			default:
				break;
			}
			
			ckshop.open(player);
		}
	}
	
}
