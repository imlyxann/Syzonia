package fr.syzonia.hub.item.shop;

import org.bukkit.Color;
import org.bukkit.Material;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.syzonia.hub.VirtualMenu.VirtualMenu;
import fr.syzonia.hub.item.ItemBuilder;

public class LoadShopMainMenuItem {

	public void Load(VirtualMenu inv) {
		ItemStack GLASS_PANE = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 2);
		ItemMeta GLASS_PANEMETA = GLASS_PANE.getItemMeta();
		GLASS_PANEMETA.setDisplayName("");
		GLASS_PANE.setItemMeta(GLASS_PANEMETA);
		
		inv.setItem(3, new ItemBuilder().type(Material.PISTON_BASE).name("§6Gadgets").lore("§7Permet d'accéder à la boutique des Gadgets!").build());
		inv.setItem(5, new ItemBuilder().type(Material.ENDER_CHEST).name("§6Lootboxs").lore("§7Permet d'accéder à la boutique des Lootboxs!").build());
		inv.setItem(20, new ItemBuilder().type(Material.BOOK).name("§6Kits").lore("§7Permet d'accéder à la boutique des kits!").build());
		inv.setItem(24, new ItemBuilder().type(Material.SADDLE).name("§6Montures").lore("§7Permet d'accéder à la boutique des montures!").build());
		inv.setItem(29, new ItemBuilder().type(Material.MAGMA_CREAM).name("§6Particules").lore("§7Permet d'accéder à la boutique des particules!").build());
		inv.setItem(33, new ItemBuilder().type(Material.DRAGON_EGG).name("§6Familliers").lore("§7Permet d'accéder à la boutique des familliers!").build());
		inv.setItem(13, new ItemBuilder().type(Material.LEATHER_HELMET).name("§dChapeaux").lore("§7Permet d'accéder à la boutique des chapeaux !").setLeatherColor(Color.BLACK).build());
		inv.setItem(22, new ItemBuilder().type(Material.LEATHER_CHESTPLATE).name("§dPulls").lore("§7Permet d'accéder à la boutique des pulls !").setLeatherColor(Color.BLACK).build());	
		inv.setItem(31, new ItemBuilder().type(Material.LEATHER_LEGGINGS).name("§dPantalons").lore("§7Permet d'accéder à la boutique des pantalons !").setLeatherColor(Color.BLACK).build());		
		inv.setItem(40, new ItemBuilder().type(Material.LEATHER_BOOTS).name("§dChaussures").lore("§7Permet d'accéder à la boutique des Chaussures !").setLeatherColor(Color.BLACK).build());
		inv.setItem(48, new ItemBuilder().type(Material.SNOW_BALL).name("§6Titres").lore("§7Permet d'accéder à la boutique des Titres! §c(InDev)").build());
		inv.setItem(50, new ItemBuilder().type(Material.GOLDEN_APPLE).data((byte) 1).name("§cSoon").lore("§a§lChut :o").build());
		
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
		
		
	}
	
}
