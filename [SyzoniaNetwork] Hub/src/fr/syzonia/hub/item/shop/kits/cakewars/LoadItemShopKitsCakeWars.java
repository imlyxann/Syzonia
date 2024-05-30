package fr.syzonia.hub.item.shop.kits.cakewars;


import org.bukkit.Material;
import org.bukkit.entity.Player;

import fr.syzonia.core.price.PriceUtils;
import fr.syzonia.syzodb.kits.cakewars.CakeWarsKitsManager;
import fr.syzonia.hub.VirtualMenu.VirtualMenu;
import fr.syzonia.hub.item.ItemBuilder;

public class LoadItemShopKitsCakeWars {

	public void LoadItem(VirtualMenu menu, Player player) {
		if(CakeWarsKitsManager.Ranger.getPlayerKit(player.getUniqueId()) == 1) {
			menu.setItem(0, new ItemBuilder().type(Material.IRON_SWORD).name("§6Kit Ranger").lore("§8----------§6Kit Ranger§8----------", "§6Kits > CakeWars", "§6Permet d'avoir 1 §ccoeur §6en plus!", "§ePermet d'avoir du skilzzz!", "§8-----------------------------", "§c(Ne ruine pas le jeux!)", "§8-----------------------------", "§8", "§cVous possédez ce Kit").build());
		} else {
			menu.setItem(0, new ItemBuilder().type(Material.IRON_SWORD).name("§6Kit Ranger").lore("§8----------§6Kit Ranger§8----------", "§6Kits > CakeWars", "§6Permet d'avoir 1 §ccoeur §6en plus!", "§ePermet d'avoir du skilzzz!", "§8-----------------------------", "§c(Ne ruine pas le jeux!)", "§8-----------------------------", "§8", "Achetez cet Kit " + new PriceUtils().Price(130) + " SyzoCoins " + new PriceUtils().getPromo(280)).build());
		}
		
		if(CakeWarsKitsManager.Gladiator.getPlayerKit(player.getUniqueId()) == 1) {
			menu.setItem(1, new ItemBuilder().type(Material.WOOL).name("§6Kit Gladiator").lore("§8----------§6Kit Gladiator§8----------", "§6Kits > CakeWars", "§6Permet d'avoir 16 Blocs de Laine + 5 Blocs de Bois en plus!", "§ePermet d'avoir du skilzzz!", "§8-----------------------------", "§c(Ne ruine pas le jeux!)", "§8-----------------------------", "§8", "§cVous possédez ce Kit").build());

		} else {
			menu.setItem(1, new ItemBuilder().type(Material.WOOL).name("§6Kit Gladiator").lore("§8----------§6Kit Gladiator§8----------", "§6Kits > CakeWars", "§6Permet d'avoir 16 Blocs de Laine + 5 Blocs de Bois en plus!", "§ePermet d'avoir du skilzzz!", "§8-----------------------------", "§c(Ne ruine pas le jeux!)", "§8-----------------------------", "§8", "Achetez cet Kit " + new PriceUtils().Price(130) + " SyzoCoins " + new PriceUtils().getPromo(280)).build());
		}
	}
	
}
