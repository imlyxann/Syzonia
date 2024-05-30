package fr.syzonia.hub.VirtualMenu.MainMenu;


import org.bukkit.Bukkit;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import fr.syzonia.syzodb.mysql.PlayerInfo;
import fr.syzonia.hub.VirtualHubs.VirtualHubs;
import fr.syzonia.hub.VirtualMenu.VirtualMenu;
import fr.syzonia.hub.VirtualMenu.Friends.VirtualFriends;
import fr.syzonia.hub.VirtualMenu.Preferences.VirtualPref;
import fr.syzonia.hub.VirtualMenu.minigames.VirtualMiniGamesMenu;
import fr.syzonia.hub.VirtualMenu.vip.VirtualVipMenu;
import fr.syzonia.hub.VirtualProfil.VirtualProfilMain;
import fr.syzonia.hub.VirtualShop.VirtualShopMenu;
import fr.syzonia.hub.item.MainMenu.LoadMainMenuItem;


public class VirtualMainMenu extends VirtualMenu implements Listener{
	
	public VirtualMainMenu() {
		super("§6Menu Principal", 9 * 6);
		
	}
	
	public void open(Player player) {
		new LoadMainMenuItem().LoadItem(this, player);
		OpenInventory(player);
	}
	

	
	@EventHandler
	public void PlayerInvClick(InventoryClickEvent event) {
		if(event.getCurrentItem() == null && event.getAction() != null) return;
		
		Player player = (Player) event.getWhoClicked();
		Inventory inv = event.getInventory();
		World world = Bukkit.getWorld("world");
		PlayerInfo playerinfo = PlayerInfo.getInfos(player.getUniqueId());
		
		if(inv.getName().equalsIgnoreCase("§6Menu Principal")) {
			event.setCancelled(true);
			
			switch (event.getCurrentItem().getType()) {
			case BED:
				
				Location loc = new Location(world, world.getSpawnLocation().getX(), world.getSpawnLocation().getY(), world.getSpawnLocation().getZ());
				player.teleport(loc);
				player.playSound(player.getEyeLocation(), Sound.VILLAGER_YES, 3, 3);
				
				break;
				
			case GOLD_BOOTS:
				
				player.sendMessage("§cPlus tard.");
				
				break;
				
			case TNT:
				
				new VirtualMiniGamesMenu().open(player);
				
				break;
				
			case NETHER_STAR:
				
				new VirtualShopMenu().open(player);
				
				break;
				
			case EMERALD:
				
				new VirtualFriends().open(player);
				
				break;
				
			case COOKIE:
				
				new VirtualHubs().open(player);
				
				break;
				
			case PAPER:
				
				new VirtualPref().open(player);
				
				break;
				
			case SKULL_ITEM:
				
				new VirtualProfilMain().open(player);
				
				break;
				
			case ARROW:
				
				player.closeInventory();
				
				break;
				
			case DIAMOND_AXE:
				
				if(playerinfo.getRank() > 0) {
					new VirtualVipMenu().open(player);;
				}
				
				break;


			default:
				break;
			}
			
		}
		
	}

	
	
}
