package fr.syzonia.hub.VirtualGame.cakewars.servers;

import java.util.ArrayList;




import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.syzonia.hub.VirtualGame.VirtualGame;
import fr.syzonia.hub.VirtualGame.cakewars.VirtualGameCakeWars;
import fr.syzonia.hub.VirtualShop.Kit.CakeWars.KitCakeWarsShop;
import fr.syzonia.hub.game.GameUtils;
import fr.syzonia.hub.item.ItemBuilder;
import fr.syzonia.hub.itemutils.ItemUtils;
import fr.syzonia.syzodb.mysql.PlayerInfo;
import fr.syzonia.syzodb.mysql.game.CakeWarsGameManager;

public class ServersCakeMenu extends VirtualGame implements Listener {
	
	public ServersCakeMenu() {
		super("CakeWars", "§bCakeWars > Serveurs", 9 * 6, 1);
	}
	
	public void open(Player player) {
		ChooseType(this, player);
		OpenInventory(player);
	}

	@EventHandler
	public void PlayerInv(InventoryClickEvent event) {
		if(event.getCurrentItem() == null && event.getAction() != null) return;
		
		if(event.getInventory().getName().equalsIgnoreCase("§bCakeWars > Serveurs")) {
			
			ItemStack item = event.getCurrentItem();
			Player player = (Player) event.getWhoClicked();
			PlayerInfo playerinfo = PlayerInfo.getInfos(player.getUniqueId());
			
			switch (item.getType()) {
			
			case BLAZE_POWDER:
				
				switch (item.getItemMeta().getDisplayName().substring(2)) {
				case "Solo":
					
					ServersSolo(this, player);
					
					break;
				
				case "Duo":
					
					ServersDuo(this, player);
					
					break;

				default:
					break;
				}
				
				break;
			
			case IRON_AXE:
				
				String name = item.getItemMeta().getDisplayName().substring(2);
				
				if(GameUtils.isInVip(name) && playerinfo.getRank() == 1) {
					player.sendMessage("§cServeur uniquement pour les Vips");
					return; 
				}
				
				if(GameUtils.isAccessible(gamename, name)) {
					GameUtils.sendToServer(player, name);
					return;
				} 
				
				player.sendMessage("§cServeur pas Accesible!");
				
				
				
				
				break;
				
			case ENDER_PEARL:
				
				new VirtualGameCakeWars().Open(player);
				
				break;
				
			case GOLD_INGOT:
				
				new KitCakeWarsShop().open(player);
				
				break;
				
			case PAPER:
				
				this.open(player);
				
				break;
				
				

			default:
					break;
					}
			}
	}
	
	public void ChooseType(VirtualGame menu, Player player) {
			this.clear();
		 	ItemStack Quit = new ItemStack(Material.ARROW);
			ItemMeta QuitMeta = Quit.getItemMeta();
			QuitMeta.setDisplayName(ChatColor.RED + "Quitter");
			Quit.setItemMeta(QuitMeta);
			
			ItemStack GLASS_PANE = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);
			ItemMeta GLASS_PANEMETA = GLASS_PANE.getItemMeta();
			GLASS_PANEMETA.setDisplayName("");
			GLASS_PANE.setItemMeta(GLASS_PANEMETA);
			
			ItemStack BOUTIQUE = new ItemStack(Material.GOLD_INGOT);
			ItemMeta BOUTIQUEMETA = BOUTIQUE.getItemMeta();
			BOUTIQUEMETA.setDisplayName(ChatColor.GOLD + "§eBoutique du CakeWars");
			List<String> BOUTIQUELORE = new ArrayList<>();
			BOUTIQUELORE.add("§6Permet d'accéder à la boutique du cakewars!");
			BOUTIQUEMETA.setLore(BOUTIQUELORE);
			BOUTIQUE.setItemMeta(BOUTIQUEMETA);
			
			
			// Glass
			inv.setItem(0, GLASS_PANE);
			inv.setItem(1, GLASS_PANE);
			inv.setItem(7, GLASS_PANE);
			inv.setItem(8, GLASS_PANE);
			inv.setItem(9, GLASS_PANE);
			inv.setItem(17, GLASS_PANE);
			inv.setItem(36, GLASS_PANE);
			inv.setItem(44, GLASS_PANE);
			inv.setItem(45, GLASS_PANE);
			inv.setItem(46, GLASS_PANE);
			inv.setItem(47, GLASS_PANE);
			inv.setItem(51, GLASS_PANE);
			inv.setItem(52, GLASS_PANE);
			inv.setItem(53, GLASS_PANE);
			
			
			inv.setItem(3, new ItemBuilder().type(Material.ENDER_PEARL).name("§6Jouer").lore("§eVous voulez jouer au cakewars cliquez sur l'item!").build());
			inv.setItem(21, new ItemBuilder().type(Material.BLAZE_POWDER).name("§6Solo").lore("§eServeurs Solo").build());
			inv.setItem(22, null);
			inv.setItem(23,  new ItemBuilder().type(Material.BLAZE_POWDER).name("§6Duo").lore("§eServeurs Duo").build());
			inv.setItem(4, BOUTIQUE);
			inv.setItem(5, new ItemBuilder().type(Material.PAPER).name("§dServeurs").lore("§eListe des serveurs du CakeWars").build());
			inv.setItem(49, Quit);
	}
	
	
	public void ServersSolo(VirtualGame menu, Player player) {
		CakeWarsGameManager game = new CakeWarsGameManager();
		
		this.clear();
		ItemUtils.setBorder(menu, 1);
		menu.setItem(4, BoutiqueItemUtils());
		menu.setItem(3, new ItemBuilder().type(Material.ENDER_PEARL).name("§6Jouer").lore("§eVous voulez jouer au cakewars cliquez sur l'item!").build());
		menu.setItem(5, new ItemBuilder().type(Material.PAPER).name("§dServeurs").lore("§eListe des serveurs du CakeWars").build());
		
		if(game.getServers() == 0) {
			menu.setItem(22, new ItemBuilder().type(Material.BARRIER).name("§cNo Servers ¯\\_(ツ)_/¯").lore("").build());
			menu.OpenInventory(player);
			return;
		}
		
		if(game.getServers() > 0) {
			int count = 0;
			
			for(int x = 1; x <= game.getServers(); x++) {
				if(game.getType("cksp" + x).equals("SOLO")) {
					count++;
				}
			}
			
			if(count == 0) {
				menu.setItem(22, new ItemBuilder().type(Material.BARRIER).name("§cNo Servers ¯\\_(ツ)_/¯").lore("").build());
				menu.OpenInventory(player);
				return;
			}
		}
		
		for(int x = 1; x <= game.getServers(); x++) {
			if(game.getType("cksp" + x).equals("SOLO")) {
				menu.setItem(19 + x, new ItemBuilder().type(Material.IRON_AXE).name("§6cksp" + x).lore("§eAccéder à ce cakewars!" , (GameUtils.isAccessible(gamename, "cksp" + x)) ? "§aAccessible" : "§cPas Accessible!", "", (GameUtils.isInVip(gamename)) ? "§d§oVIP" : null, "§f» §3Solo", "§c(Clique-Droit) §f» §6Accéder au Serveur").build());
			}
		}
		
		menu.OpenInventory(player);
	}
	
	public void ServersDuo(VirtualGame menu, Player player) {
		CakeWarsGameManager game = new CakeWarsGameManager();
		
		this.clear();
		ItemUtils.setBorder(menu, 1);
		menu.setItem(4, BoutiqueItemUtils());
		menu.setItem(3, new ItemBuilder().type(Material.ENDER_PEARL).name("§6Jouer").lore("§eVous voulez jouer au cakewars cliquez sur l'item!").build());
		menu.setItem(5, new ItemBuilder().type(Material.PAPER).name("§dServeurs").lore("§eListe des serveurs du CakeWars").build());
		
		if(game.getServers() == 0) {
			menu.setItem(22, new ItemBuilder().type(Material.BARRIER).name("§cNo Servers ¯\\_(ツ)_/¯").lore("").build());
			menu.OpenInventory(player);
			return;
		}
		
		if(game.getServers() > 0) {
			int count = 0;
			
			for(int x = 1; x <= game.getServers(); x++) {
				if(game.getType("ckdp" + x).equals("DUO")) {
					count++;
				}
			}
			
			if(count == 0) {
				menu.setItem(22, new ItemBuilder().type(Material.BARRIER).name("§cNo Servers ¯\\_(ツ)_/¯").lore("").build());
				menu.OpenInventory(player);
				return;
			}
		}
		
		for(int x = 1; x <= game.getServers(); x++) {
			if(game.getType("ckdp" + x).equals("DUO")) {
				menu.setItem(19 + x, new ItemBuilder().type(Material.IRON_AXE).name("§6ckdp" + x).lore("§eAccéder à ce cakewars!" , (GameUtils.isAccessible(gamename, "ckdp" + x)) ? "§aAccessible" : "§cPas Accessible!", "", (GameUtils.isInVip(gamename)) ? "§d§oVIP" : null, "§f» §3Duo", "§c(Clique-Droit) §f» §6Accéder au Serveur").build());
			}
		}
		
		menu.OpenInventory(player);
	}
	
	public ItemStack BoutiqueItemUtils() {
		ItemStack BOUTIQUE = new ItemStack(Material.GOLD_INGOT);
		ItemMeta BOUTIQUEMETA = BOUTIQUE.getItemMeta();
		BOUTIQUEMETA.setDisplayName(ChatColor.GOLD + "§eBoutique du CakeWars");
		List<String> BOUTIQUELORE = new ArrayList<>();
		BOUTIQUELORE.add("§6Permet d'accéder à la boutique du cakewars!");
		BOUTIQUEMETA.setLore(BOUTIQUELORE);
		BOUTIQUE.setItemMeta(BOUTIQUEMETA);
		return BOUTIQUE;
	}
	
	
}
