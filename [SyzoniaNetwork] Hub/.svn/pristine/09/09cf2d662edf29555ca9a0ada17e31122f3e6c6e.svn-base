package fr.syzonia.hub.item.shop.mount;

import org.bukkit.Material;


import org.bukkit.entity.Player;

import fr.syzonia.core.price.PriceUtils;
import fr.syzonia.syzodb.shop.mount.Mountdata;
import fr.syzonia.hub.VirtualMenu.VirtualMenu;
import fr.syzonia.hub.item.ItemBuilder;

public class LoadMountShopItem {

	public void LoadItem(VirtualMenu inv ,Player player) {
		inv.setItem(0, new ItemBuilder().type(Material.BONE).name("§eLoup").lore("§8----------§6Loup§8----------", "§6Montures", "§ePermet de se déplacer en toute beauté!", "§8-----------------------------", "§8",(Mountdata.haveMount(95, player) ? "Vous possédez cette Monture" : "Achetez cette Monture " + new PriceUtils().Price(120) + " SyzoCoins " + new PriceUtils().getPromo(120))).build());
		inv.setItem(1, new ItemBuilder().type(Material.WHEAT).name("§eVache").lore("§8----------§6Vache§8----------", "§6Montures", "§ePermet de se déplacer en toute beauté!", "§8-----------------------------", "§8",(Mountdata.haveMount(92, player) ? "Vous possédez cette Monture" : "Achetez cette Monture " + new PriceUtils().Price(140) +" SyzoCoins " + new PriceUtils().getPromo(140))).build());
		inv.setItem(2, new ItemBuilder().type(Material.CARROT_ITEM).name("§eCochon").lore("§8----------§6Cochon§8----------", "§6Montures", "§ePermet de se déplacer en toute beauté!", "§8-----------------------------", "§8",(Mountdata.haveMount(90, player) ? "Vous possédez cette Monture" : "Achetez cette Monture " + new PriceUtils().Price(170) + " SyzoCoins " + new PriceUtils().getPromo(170))).build());
		inv.setItem(3, new ItemBuilder().type(Material.WOOL).name("§eMouton §cF§ee§bs§6t§di§2f").lore("§8----------§6Mouton §cF§ee§bs§6t§di§2f§8----------", "§6Montures", "§ePermet de se déplacer en toute beauté!", "§8-----------------------------", "§8",(Mountdata.haveMount(91, player) ? "Vous possédez cette Monture" : "Achetez cette Monture " + new PriceUtils().Price(200) + " SyzoCoins " + new PriceUtils().getPromo(200))).build());
	}
	
}
