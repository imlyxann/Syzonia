package fr.syzonia.hub.VirtualShop;


import org.bukkit.entity.Player;



import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import fr.syzonia.hub.VirtualMenu.VirtualMenu;
import fr.syzonia.hub.VirtualShop.Gadgets.GadgetsShop;
import fr.syzonia.hub.VirtualShop.Kit.KitGameChooseMenu;
import fr.syzonia.hub.VirtualShop.Lootboxs.LootboxShop;
import fr.syzonia.hub.VirtualShop.Mounts.MountShop;
import fr.syzonia.hub.VirtualShop.Particules.ParticulesShop;
import fr.syzonia.hub.VirtualShop.Pets.PetsShop;
import fr.syzonia.hub.VirtualShop.Vetements.ChapeauxShop;
import fr.syzonia.hub.VirtualShop.Vetements.ChaussureShop;
import fr.syzonia.hub.VirtualShop.Vetements.PantalonShop;
import fr.syzonia.hub.VirtualShop.Vetements.PullShop;
import fr.syzonia.hub.item.shop.LoadShopMainMenuItem;

public class VirtualShopMenu extends VirtualMenu implements Listener{

	public VirtualShopMenu() {
		super("§dShop", 9 * 6);
	}

	public void open(Player player) {
		new LoadShopMainMenuItem().Load(this);
		OpenInventory(player);
	}
	
	@EventHandler
	public void PlayerInv(InventoryClickEvent event) {
		if(event.getCurrentItem() == null && event.getAction() != null) return;
		
		if(event.getInventory().getName().equalsIgnoreCase("§dShop")) {
			event.setCancelled(true);
			
			Player player = (Player) event.getWhoClicked();
			
			switch (event.getCurrentItem().getType()) {
			case SADDLE:
				
				new MountShop().open(player);
				
				break;
				
			case BOOK:
			
				new KitGameChooseMenu().open(player);
				
				break;
				
				
			case MAGMA_CREAM:
				
				new ParticulesShop().open(player);
				
				break;
				
			case DRAGON_EGG:
				
				new PetsShop().open(player);
				
				break;
				

			case PISTON_BASE:
			
				new GadgetsShop().Open(player);
			
				break;
				
				
			case LEATHER_HELMET:
				
				new ChapeauxShop().open(player);
				
				break;
				
			case LEATHER_CHESTPLATE:
				
				new PullShop().open(player);
				
				break;
				
			case LEATHER_LEGGINGS:
				
				new PantalonShop().open(player);
				
				break;
				
			case LEATHER_BOOTS:
				
				new ChaussureShop().open(player);
				
				break;
				
			case ENDER_CHEST:
				
				new LootboxShop().open(player);
				
				break;
				
			default:
				break;
			}
			
			
			
		}
	}
	
	
	
}
