package fr.syzonia.hub.item.game;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.syzonia.hub.VirtualGame.VirtualGame;
import fr.syzonia.hub.item.ItemBuilder;

public class LoadCakeWarsItem {

	public void load(Player player, VirtualGame inv) {
        
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
		inv.setItem(21, null);
		inv.setItem(22, new ItemBuilder().type(Material.EYE_OF_ENDER).name("§6Jouer Maintenant").lore("§eJouer Maintenant au cakewars!").build());
		inv.setItem(23, null);
		inv.setItem(4, BOUTIQUE);
		inv.setItem(5, new ItemBuilder().type(Material.PAPER).name("§dServeurs").lore("§eListe des serveurs du CakeWars").build());
		inv.setItem(49, Quit);


		
	}
	
}
