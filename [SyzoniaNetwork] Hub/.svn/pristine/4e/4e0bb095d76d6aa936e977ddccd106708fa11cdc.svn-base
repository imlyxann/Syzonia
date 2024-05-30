package fr.syzonia.hub.item.shop.particules;

import org.bukkit.DyeColor;


import org.bukkit.Material;
import org.bukkit.entity.Player;

import fr.syzonia.core.price.PriceUtils;
import fr.syzonia.syzodb.shop.particules.ParticulesData;
import fr.syzonia.hub.VirtualMenu.VirtualMenu;
import fr.syzonia.hub.item.ItemBuilder;

public class LoadItemShopParticules {

	@SuppressWarnings("deprecation")
	public void LoadItem(VirtualMenu inv, Player player) {
		inv.setItem(0, new ItemBuilder().type(Material.FIREBALL).name("§6La Lueur sanglante").lore("§8----------§6La Lueur sanglante§8----------", "§6Particules", "§ePermet de se déplacer en toute beauté!", "§8-----------------------------", "§8",(ParticulesData.haveParticules(1, player) ? "Vous possédez cette Particules" : "Achetez cette Particule " + new PriceUtils().Price(130) + " SyzoCoins " + new PriceUtils().getPromo(130))).build());
		inv.setItem(1, new ItemBuilder().type(Material.FURNACE).name("§6Le Moteur enfumé").lore("§8----------§6Le Moteur enfumé§8----------", "§6Particules", "§ePermet de se déplacer en toute beauté!", "§8-----------------------------", "§8",(ParticulesData.haveParticules(2, player) ? "Vous possédez cette Particules" : "Achetez cette Particule " + new PriceUtils().Price(140) + " SyzoCoins " + new PriceUtils().getPromo(140))).build());
		inv.setItem(2, new ItemBuilder().type(Material.INK_SACK).data((byte) (15 - DyeColor.PINK.getData())).name("§6Les Coeurs tombants").lore("§8----------§6Les Coeurs tombants§8----------", "§6Particules", "§8-----------------------------", "§8",(ParticulesData.haveParticules(3, player) ? "Vous possédez cette Particules" : "Achetez cette Particule " + new PriceUtils().Price(180) + " SyzoCoins " + new PriceUtils().getPromo(180))).build());
		inv.setItem(3, new ItemBuilder().type(Material.NETHER_STAR).name("§6L'Etoile Filante").lore("§8----------§6L'Etoile Filante§8----------", "§6Particules", "§ePermet de se déplacer en toute beauté!", "§8-----------------------------", "§8",(ParticulesData.haveParticules(4, player) ? "Vous possédez cette Particules" : "Achetez cette Particule " + new PriceUtils().Price(200) + " SyzoCoins" + new PriceUtils().getPromo(200))).build());
	}
	
}
