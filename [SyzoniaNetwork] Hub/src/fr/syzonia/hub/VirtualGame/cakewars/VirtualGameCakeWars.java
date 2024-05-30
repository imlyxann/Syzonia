package fr.syzonia.hub.VirtualGame.cakewars;

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

import fr.syzonia.core.title.Title;
import fr.syzonia.syzodb.mysql.queue.QueueManager;
import fr.syzonia.hub.VirtualGame.VirtualGame;
import fr.syzonia.hub.VirtualGame.cakewars.servers.ServersCakeMenu;
import fr.syzonia.hub.VirtualShop.Kit.CakeWars.KitCakeWarsShop;
import fr.syzonia.hub.item.ItemBuilder;
import fr.syzonia.hub.item.game.LoadCakeWarsItem;

public class VirtualGameCakeWars extends VirtualGame implements Listener{

	public static List<String> OpenedServersGui = new ArrayList<String>();
	
	public VirtualGameCakeWars() {
		super("CakeWars", "§bCakeWars", 9 * 6, 1);
	}

	public void Open(Player player) {
		new LoadCakeWarsItem().load(player, this);
		OpenedServersGui.add(player.getName());
		OpenInventory(player);
	}
	
	@EventHandler
	public void PlayerInv(InventoryClickEvent event) {
		ItemStack item = event.getCurrentItem();
		Player player = (Player) event.getWhoClicked();
		
		if(item == null && event.getAction() != null) return;
		
		if(event.getInventory().getName().equalsIgnoreCase("§bCakeWars")) {
			
			switch (item.getType()) {
			
			case ENDER_PEARL:
				
				Jouer(this, player);
				
				break;
			
			
			case GOLD_INGOT:
				
				new KitCakeWarsShop().open(player);
				
				break;
				
			case PAPER:
				
				new ServersCakeMenu().open(player);
				
				break;
				
			case EYE_OF_ENDER:
			
				if(!new QueueManager().isInQueue(player)) {
					Choose(this, player);	
					
				} else {
						player.closeInventory();
						player.sendMessage("§cTu es déjà dans la file d'attente");
					}
				
				
					break;	
					
			case CAKE:
				
				switch (event.getCurrentItem().getItemMeta().getDisplayName()) {
				case "§eSolo":
					
					if(player.getInventory().getItem(4) == null) {
						new QueueManager().addQueudedPlayer(player, 1, "SOLO", 0);
							
						new Title().sendFullTitle(player, 10, 60, 10, "§6File d'attente", "§eTu es placé(e) dans une file d'attente du CakeWars!");
						player.closeInventory();
						player.getInventory().setItem(4, new ItemBuilder().type(Material.NAME_TAG).name("§cQuitter").lore("§7Permet de quitter la file d'attente des mini-jeux").build());
					} else {
						player.sendMessage("§cTu as un gadget ou un objet dans ton inventaire!");
					}	 
					
					break;
					
				case "§eDuo":
					
					if(player.getInventory().getItem(4) == null) {
						new QueueManager().addQueudedPlayer(player, 1, "DUO", 0);
							
						new Title().sendFullTitle(player, 10, 60, 10, "§6File d'attente", "§eTu es placé(e) dans une file d'attente du CakeWars!");
						player.closeInventory();
						player.getInventory().setItem(4, new ItemBuilder().type(Material.NAME_TAG).name("§cQuitter").lore("§7Permet de quitter la file d'attente des mini-jeux").build());
					} else {
						player.sendMessage("§cTu as un gadget ou un objet dans ton inventaire!");
					}	 
					
					break;

				default:
					break;
				}
				
				break;
				
			default:
					break;
					}
			}
	}
	
	public void Choose(VirtualGame menu, Player player) {
		
        ItemStack Quit = new ItemStack(Material.ARROW);
		ItemMeta QuitMeta = Quit.getItemMeta();
		QuitMeta.setDisplayName(ChatColor.RED + "Quitter");
		Quit.setItemMeta(QuitMeta);
		
		
		ItemStack BOUTIQUE = new ItemStack(Material.GOLD_INGOT);
		ItemMeta BOUTIQUEMETA = BOUTIQUE.getItemMeta();
		BOUTIQUEMETA.setDisplayName(ChatColor.GOLD + "§eBoutique du CakeWars");
		List<String> BOUTIQUELORE = new ArrayList<>();
		BOUTIQUELORE.add("§6Permet d'accéder à la boutique du cakewars!");
		BOUTIQUEMETA.setLore(BOUTIQUELORE);
		BOUTIQUE.setItemMeta(BOUTIQUEMETA);
		
		ItemStack GLASS_PANE = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);
		ItemMeta GLASS_PANEMETA = GLASS_PANE.getItemMeta();
		GLASS_PANEMETA.setDisplayName("");
		GLASS_PANE.setItemMeta(GLASS_PANEMETA);
		
		menu.setItem(0, GLASS_PANE);
		menu.setItem(1, GLASS_PANE);
		menu.setItem(7, GLASS_PANE);
		menu.setItem(8, GLASS_PANE);
		menu.setItem(9, GLASS_PANE);
		menu.setItem(17, GLASS_PANE);
		menu.setItem(36, GLASS_PANE);
		menu.setItem(44, GLASS_PANE);
		menu.setItem(45, GLASS_PANE);
		menu.setItem(46, GLASS_PANE);
		menu.setItem(47, GLASS_PANE);
		menu.setItem(51, GLASS_PANE);
		menu.setItem(52, GLASS_PANE);
		menu.setItem(53, GLASS_PANE);
		
		menu.setItem(21, new ItemBuilder().type(Material.CAKE).name("§eSolo").build());
		menu.setItem(22, null);
		menu.setItem(23, new ItemBuilder().type(Material.CAKE).name("§eDuo").build());
		
		menu.setItem(3, new ItemBuilder().type(Material.ENDER_PEARL).name("§6Jouer").lore("§eVous voulez jouer au cakewars cliquez sur l'item!").build());
		menu.setItem(4, BOUTIQUE);
		menu.setItem(5, new ItemBuilder().type(Material.PAPER).name("§dServeurs").lore("§eListe des serveurs du CakeWars").build());
		
		menu.setItem(49, Quit);
		
		menu.OpenInventory(player);
	}
	
	public void Jouer(VirtualGame menu, Player player) {
		new LoadCakeWarsItem().load(player, this);
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
